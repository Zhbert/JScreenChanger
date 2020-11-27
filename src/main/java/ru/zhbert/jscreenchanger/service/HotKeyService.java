package ru.zhbert.jscreenchanger.service;

import com.tulskiy.keymaster.common.HotKey;
import com.tulskiy.keymaster.common.HotKeyListener;
import com.tulskiy.keymaster.common.Provider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class HotKeyService {

    private Provider provider = Provider.getCurrentProvider(false);

    private HotKeyListener listener;

    public HotKeyService() {
        this.listener = new HotKeyListener() {
            public void onHotKey(HotKey hotKey) {
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int screenHeight = screenSize.height;
                int screenWidth = screenSize.width;
                Robot robot = null;
                try {
                    robot = new Robot();
                } catch (AWTException e) {
                    e.printStackTrace();
                }
                robot.mouseMove(screenWidth/2, screenHeight/2);
            }
        };
    }

    public void start() {
        provider.register(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, InputEvent.CTRL_MASK), listener);
    }

    public void stop() {
        provider.reset();
        provider.stop();
    }
}
