package ru.zhbert.jscreenchanger.service;

import com.tulskiy.keymaster.common.HotKey;
import com.tulskiy.keymaster.common.HotKeyListener;
import com.tulskiy.keymaster.common.Provider;
import ru.zhbert.jscreenchanger.domain.SettingsFileData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class HotKeyService {

    private Provider provider = Provider.getCurrentProvider(false);
    private SettingsFileData settingsFileData;
    private Robot robot;
    private HotKeyListener listener = new HotKeyListener() {
        public void onHotKey(HotKey hotKey) {
            switch (settingsFileData.getSCREENS_COUNT()) {
                case 1 :
                    robot.mouseMove(settingsFileData.getFIRST_SCREEN_W_POS(), settingsFileData.getFIRST_SCREEN_H_POS());
                    break;
                case 2 :
                    if (checkScreen() == 1) {
                        robot.mouseMove(settingsFileData.getSECOND_SCREEN_W_POS(), settingsFileData.getSECOND_SCREEN_H_POS());
                    } else if (checkScreen() == 2) {
                        robot.mouseMove(settingsFileData.getFIRST_SCREEN_W_POS(), settingsFileData.getFIRST_SCREEN_H_POS());
                    }
                    break;
                case 3 :
                    if (checkScreen() == 1) {
                        robot.mouseMove(settingsFileData.getSECOND_SCREEN_W_POS(), settingsFileData.getSECOND_SCREEN_H_POS());
                    } else if (checkScreen() == 2) {
                        robot.mouseMove(settingsFileData.getTHIRD_SCREEN_W_POS(), settingsFileData.getTHIRD_SCREEN_H_POS());
                    } else if (checkScreen() == 3) {
                        robot.mouseMove(settingsFileData.getFIRST_SCREEN_W_POS(), settingsFileData.getFIRST_SCREEN_H_POS());
                    }
                    break;
                default:
                    break;
            }
        }
    };

    public HotKeyService(SettingsFileData settingsFileData) throws AWTException {
        this.settingsFileData = settingsFileData;
        robot = new Robot(MouseInfo.getPointerInfo().getDevice());
        provider.register(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, InputEvent.CTRL_MASK), listener);
    }

    public void stop() {
        provider.reset();
        provider.stop();
    }

    private int checkScreen() {
        System.out.println(MouseInfo.getPointerInfo().getLocation().getX() + " " + MouseInfo.getPointerInfo().getLocation().getY());
        if (MouseInfo.getPointerInfo().getLocation().getX() > settingsFileData.getFIRST_SCREEN_MIN() ||
                MouseInfo.getPointerInfo().getLocation().getX() < settingsFileData.getFIRST_SCREEN_MAX()) {
            return 1;
        }
        if (MouseInfo.getPointerInfo().getLocation().getX() > settingsFileData.getSECOND_SCREEN_MIN() ||
                MouseInfo.getPointerInfo().getLocation().getX() < settingsFileData.getSECOND_SCREEN_MAX()) {
            return 2;
        }
        if (MouseInfo.getPointerInfo().getLocation().getX() > settingsFileData.getTHIRD_SCREEN_MIN() ||
                MouseInfo.getPointerInfo().getLocation().getX() < settingsFileData.getTHIRD_SCREEN_MAX()) {
            return 3;
        }
        return 1;
    }
}
