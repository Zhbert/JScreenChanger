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

    public static void main(String[] args) throws IOException, AWTException {

        SettingsFileService settingsFileService = new SettingsFileService();

        HotKeyService hotKeyService = new HotKeyService(settingsFileService.getSettingsFileData());

        getScanner();

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
}
