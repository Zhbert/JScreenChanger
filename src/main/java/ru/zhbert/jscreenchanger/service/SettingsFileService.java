package ru.zhbert.jscreenchanger.service;

import ru.zhbert.jscreenchanger.domain.Screen;
import ru.zhbert.jscreenchanger.domain.ScreenChanger;
import ru.zhbert.jscreenchanger.domain.SettingsFileData;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @brief Class for working with settings file
 * @author zhbert
 * @copyright GPLv3
 * @date 01.2021
 * @version 0.0.1
 */
public class SettingsFileService {

    final private String settingsPath = System.getProperty("user.home") + File.separator + ".jscreenchanger";

    final private String settingsFile = "jscreenchanger.conf";

    private SettingsFileData settingsFileData;

    /**
     * @brief Class Constructor
     * @details Checks or creates a settings file.
     * @throws IOException
     */
    public SettingsFileService() throws IOException {
        File file = new File(settingsPath);
        if (!file.exists()) {
            file.mkdir();
        }

        file = new File(settingsPath + File.separator + settingsFile);
        if (file.createNewFile()) {
            System.out.println("Settings file is created!");

            settingsFileData = new SettingsFileData(0,0,0,0,0,0,0,0,0,0,0,0,0);

            Properties properties = new Properties();
            properties.setProperty("SCREENS_COUNT", String.valueOf(0));

            properties.setProperty("FIRST_SCREEN_MIN", String.valueOf(0));
            properties.setProperty("FIRST_SCREEN_MAX", String.valueOf(0));
            properties.setProperty("FIRST_SCREEN_H_POS", String.valueOf(0));
            properties.setProperty("FIRST_SCREEN_W_POS", String.valueOf(0));

            properties.setProperty("SECOND_SCREEN_MIN", String.valueOf(0));
            properties.setProperty("SECOND_SCREEN_MAX", String.valueOf(0));
            properties.setProperty("SECOND_SCREEN_H_POS", String.valueOf(0));
            properties.setProperty("SECOND_SCREEN_W_POS", String.valueOf(0));

            properties.setProperty("THIRD_SCREEN_MIN", String.valueOf(0));
            properties.setProperty("THIRD_SCREEN_MAX", String.valueOf(0));
            properties.setProperty("THIRD_SCREEN_H_POS", String.valueOf(0));
            properties.setProperty("THIRD_SCREEN_W_POS", String.valueOf(0));

            FileOutputStream out = new FileOutputStream(settingsPath + File.separator + settingsFile);
            properties.store(out, null);
            out.close();
        } else {
            System.out.println("Settings file is founded.");

            FileInputStream in = new FileInputStream(settingsPath + File.separator + settingsFile);
            Properties properties = new Properties();
            properties.load(in);
            in.close();

            settingsFileData = new SettingsFileData();
            settingsFileData.setSCREENS_COUNT(Integer.valueOf(properties.getProperty("SCREENS_COUNT")));
            settingsFileData.setFIRST_SCREEN_MIN(Integer.valueOf(properties.getProperty("FIRST_SCREEN_MIN")));
            settingsFileData.setFIRST_SCREEN_MAX(Integer.valueOf(properties.getProperty("FIRST_SCREEN_MAX")));
            settingsFileData.setFIRST_SCREEN_H_POS(Integer.valueOf(properties.getProperty("FIRST_SCREEN_H_POS")));
            settingsFileData.setFIRST_SCREEN_W_POS(Integer.valueOf(properties.getProperty("FIRST_SCREEN_MIN")));

            settingsFileData.setSECOND_SCREEN_MIN(Integer.valueOf(properties.getProperty("SECOND_SCREEN_MIN")));
            settingsFileData.setSECOND_SCREEN_MAX(Integer.valueOf(properties.getProperty("SECOND_SCREEN_MAX")));
            settingsFileData.setSECOND_SCREEN_H_POS(Integer.valueOf(properties.getProperty("SECOND_SCREEN_H_POS")));
            settingsFileData.setSECOND_SCREEN_W_POS(Integer.valueOf(properties.getProperty("SECOND_SCREEN_MIN")));

            settingsFileData.setTHIRD_SCREEN_MIN(Integer.valueOf(properties.getProperty("THIRD_SCREEN_MIN")));
            settingsFileData.setTHIRD_SCREEN_MAX(Integer.valueOf(properties.getProperty("THIRD_SCREEN_MAX")));
            settingsFileData.setTHIRD_SCREEN_H_POS(Integer.valueOf(properties.getProperty("THIRD_SCREEN_H_POS")));
            settingsFileData.setTHIRD_SCREEN_W_POS(Integer.valueOf(properties.getProperty("THIRD_SCREEN_MIN")));
        }
    }

    /**
     * @brief Class getter with settings
     * @return Class with settings for cursor positions and field borders
     */
    public SettingsFileData getSettingsFileData() {
        return settingsFileData;
    }
}
