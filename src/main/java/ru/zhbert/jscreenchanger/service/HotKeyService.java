package ru.zhbert.jscreenchanger.service;

import com.tulskiy.keymaster.common.HotKey;
import com.tulskiy.keymaster.common.HotKeyListener;
import com.tulskiy.keymaster.common.Provider;
import ru.zhbert.jscreenchanger.domain.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

public class HotKeyService {

    private Provider provider = Provider.getCurrentProvider(false);
    private ArrayList<Integer> screensSet = new ArrayList<>();
    private ArrayList<Boolean> screenResolutionSet = new ArrayList<>();
    private int setCounter;
    private SettingsFileService settingsFileService;

    private HotKeyListener listener = new HotKeyListener() {
        public void onHotKey(HotKey hotKey) {
            /*Screen screen = screenPool.get(0);
            robot.mouseMove(screen.getWidthHalf(), screen.getHeightHalf());*/
            System.out.println(MouseInfo.getPointerInfo().getDevice().getIDstring() + " "
                    + MouseInfo.getPointerInfo().getDevice().getType());
        }
    };

    private HotKeyListener settingsListener;
    private ArrayList<Screen> screenPool;
    private Robot robot;

    public HotKeyService(final ArrayList<Screen> screenPool) throws AWTException {
        System.out.println("Start setting process.");

        this.settingsListener = new HotKeyListener() {
            @Override
            public void onHotKey(HotKey hotKey) {
                if (setCounter < screenPool.size()) {
                    for (Screen screen : screenPool) {
                        if (MouseInfo.getPointerInfo().getDevice().equals(screen.getGraphicsDevice())) {
                            System.out.println("Screen detected: " + screen.getScreenNumber());
                            screensSet.add(screen.getScreenNumber());
                            screenResolutionSet.add(MouseInfo.getPointerInfo().getLocation().getX()<0);
                            setCounter++;
                        }
                    }
                } else {
                    System.out.println("All the screens are set up! Closed hotkeys registrations...");
                    provider.reset();
                    provider.stop();
                    System.out.println("Writing settings in settings file...");
                    String settings = "";
                    String setbools = "";
                    for (int i : screensSet) {
                        settings = String.join(" ", settings, String.valueOf(i));
                    }
                    for (Boolean i : screenResolutionSet) {
                        setbools = String.join(" ", setbools, String.valueOf(i));
                    }
                    System.out.println("Settings string is: " + settings);
                    try {
                        settingsFileService.setSettings(settings.substring(1), setbools.substring(1));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Exiting...");
                    System.exit(0);
                }
            }
        };

        this.screenPool = screenPool;
        this.robot = new Robot();
        this.setCounter = 0;
    }

    public void start() {
        provider.register(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, InputEvent.CTRL_MASK), listener);
    }

    public void settingStart(SettingsFileService settingsFileService) {
        provider.register(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, InputEvent.CTRL_MASK), settingsListener);
        this.settingsFileService = settingsFileService;
    }

    public void stop() {
        provider.reset();
        provider.stop();
    }
}
