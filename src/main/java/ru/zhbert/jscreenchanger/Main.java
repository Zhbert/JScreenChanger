package ru.zhbert.jscreenchanger;

import ru.zhbert.jscreenchanger.domain.Screen;
import ru.zhbert.jscreenchanger.service.HotKeyService;
import ru.zhbert.jscreenchanger.service.SettingsFileService;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @brief Main class of application
 * @author Zhbert
 * @copyright GPLv3
 * @date 01.2021
 * @version 0.0.1
 *
 * In this class application is starting, generated pool of physical screens and starting
 * service of hotkeys and service for create and reading settings file.
 */
public class Main {

    public static void main(String[] args) throws AWTException, IOException {

        ArrayList<Screen> screenPool = new ArrayList<>();

        HotKeyService hotKeyService = new HotKeyService(screenPool);

        SettingsFileService settingsFileService = new SettingsFileService();
        settingsFileService.readSettings();

        viewScreenInfo(screenPool);

        if (args.length > 0) {
            String arg = args[0];
            if (arg.equals("--setup")) {
                hotKeyService.settingStart(settingsFileService);
            } else {
                hotKeyService.start(settingsFileService.setScreenChangers(screenPool));
            }
        } else {
            hotKeyService.start(settingsFileService.setScreenChangers(screenPool));
        }

        getScanner();

        System.out.println("Exiting program...");
        hotKeyService.stop();
    }

    /**
     * Function for waiting user's input.
     */
    private static void getScanner() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a command: ");
        int num = in.nextInt();
        in.close();
    }

    /**
     * Function for view info about founded screens.
     * @param screenPool
     */
    private static void viewScreenInfo(ArrayList<Screen> screenPool) {
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = environment.getScreenDevices();
        System.out.println("Screens found: " + devices.length);
        for (int i = 0; i < devices.length; i++) {
            DisplayMode displayMode = devices[i].getDisplayMode();
            screenPool.add(new Screen(displayMode.getWidth(), displayMode.getHeight(), i, devices[i]));
        }
        for (Screen screen : screenPool) {
            System.out.println(screen.toString());
        }
    }
}
