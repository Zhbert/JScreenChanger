package ru.zhbert.jscreenchanger.service;

import com.tulskiy.keymaster.common.HotKey;
import com.tulskiy.keymaster.common.HotKeyListener;
import com.tulskiy.keymaster.common.Provider;
import ru.zhbert.jscreenchanger.domain.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class HotKeyService {

    private Provider provider = Provider.getCurrentProvider(false);

    private HotKeyListener listener;

    private ArrayList<Screen> screenPool;

    private Robot robot;

    public HotKeyService(final ArrayList<Screen> screenPool) throws AWTException {
        this.listener = new HotKeyListener() {
            public void onHotKey(HotKey hotKey) {
                /*Screen screen = screenPool.get(0);
                robot.mouseMove(screen.getWidthHalf(), screen.getHeightHalf());*/
                System.out.println(MouseInfo.getPointerInfo().getDevice().getIDstring() + " " + MouseInfo.getPointerInfo().getDevice().getType());
            }
        };
        this.screenPool = screenPool;

        this.robot = new Robot();
    }

    public void start() {
        provider.register(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, InputEvent.CTRL_MASK), listener);
    }

    public void stop() {
        provider.reset();
        provider.stop();
    }
}
