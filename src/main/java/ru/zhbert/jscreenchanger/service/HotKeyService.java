package ru.zhbert.jscreenchanger.service;

import com.tulskiy.keymaster.common.HotKey;
import com.tulskiy.keymaster.common.HotKeyListener;
import com.tulskiy.keymaster.common.Provider;
import ru.zhbert.jscreenchanger.domain.Screen;
import ru.zhbert.jscreenchanger.domain.ScreenChanger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.util.ArrayList;

public class HotKeyService {

    private Provider provider = Provider.getCurrentProvider(false);
    private ArrayList<Integer> screensSet = new ArrayList<>();
    private ArrayList<Boolean> screenResolutionSet = new ArrayList<>();
    private int setCounter;
    private SettingsFileService settingsFileService;
    private ArrayList<ScreenChanger> screenChangers = new ArrayList<>();
    private Screen screen;
    private ScreenChanger chng;

    private HotKeyListener listener = new HotKeyListener() {
        public void onHotKey(HotKey hotKey) {
            for (ScreenChanger changer : screenChangers) {
                if (MouseInfo.getPointerInfo().getLocation().getX() < changer.getMaxPosition() ||
                        MouseInfo.getPointerInfo().getLocation().getX() > changer.getMinPosition()) {
                    System.out.println("_________________________");
                    System.out.println("Current position: X - " + MouseInfo.getPointerInfo().getLocation().getX() + " Y - "
                            + MouseInfo.getPointerInfo().getLocation().getY());
                    System.out.println("Current screen: " + " " + changer.getScreen().getScreenNumber());
                    System.out.println("Next screen: " + changer.getScreen().getScreenNumber());
                    System.out.println("Next position: " + changer.getNextScreenChanger().getPosition());
                    System.out.println("Next screen number: " + changer.getNextScreenChanger().getScreen().getScreenNumber());

                    screen = changer.getNextScreenChanger().getScreen();
                    chng = changer;
                    break;
                }
            }
            robot.mouseMove(chng.getNextScreenChanger().getPosition(), screen.getHeightHalf());
        }
    };

    private HotKeyListener settingsListener;
    private ArrayList<Screen> screenPool;
    private Robot robot;

    public HotKeyService(final ArrayList<Screen> screenPool) throws AWTException {
        System.out.println("Start setting process.");

        this.settingsListener = hotKey -> {
            if (setCounter < screenPool.size()) {
                for (Screen screen : screenPool) {
                    if (MouseInfo.getPointerInfo().getDevice().equals(screen.getGraphicsDevice())) {
                        System.out.println("Screen detected: " + screen.getScreenNumber());
                        screensSet.add(screen.getScreenNumber());
                        screenResolutionSet.add(MouseInfo.getPointerInfo().getLocation().getX() < 0);
                        setCounter++;
                    }
                }
            } else {
                System.out.println("All the screens are set up! Closed hotkeys registrations...");
                provider.reset();
                provider.stop();
                System.out.println("Writing settings in settings file...");
                String settings = "";
                String setBools = "";
                for (int i : screensSet) {
                    settings = String.join(" ", settings, String.valueOf(i));
                }
                for (Boolean i : screenResolutionSet) {
                    setBools = String.join(" ", setBools, String.valueOf(i));
                }
                System.out.println("Settings string is: " + settings);
                try {
                    settingsFileService.setSettings(settings.substring(1), setBools.substring(1));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Exiting...");
                System.exit(0);
            }
        };

        this.screenPool = screenPool;
        this.robot = new Robot();
        this.setCounter = 0;
    }

    public void start(ArrayList<ScreenChanger> screenChangers) {
        provider.register(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, InputEvent.CTRL_MASK), listener);
        this.screenChangers = screenChangers;
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
