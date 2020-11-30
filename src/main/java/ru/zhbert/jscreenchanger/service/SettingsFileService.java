package ru.zhbert.jscreenchanger.service;

import java.io.File;
import java.io.IOException;

public class SettingsFileService {

    private String settingsPath = System.getProperty("user.home") + File.separator + ".jscreenchanger";

    private String settingsFile = "jscreenchanger.conf";

    public SettingsFileService() throws IOException {
        File file = new File(settingsPath);
        if (!file.exists()) {
            file.mkdir();
        }

        file = new File(settingsPath + File.separator + settingsFile);
        if (file.createNewFile()){
            System.out.println("Settings file is created!");
        }
        else{
            System.out.println("Settings file is founded.");
        }

        System.out.println(file.toURI());
    }
}
