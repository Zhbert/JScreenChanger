package ru.zhbert.jscreenchanger.service;

import java.io.*;

public class SettingsFileService {

    final private String settingsPath = System.getProperty("user.home") + File.separator + ".jscreenchanger";

    final private String settingsFile = "jscreenchanger.conf";

    private String settings = null;

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

    public boolean readSettings() {
        try {
            File file = new File(settingsPath + File.separator + settingsFile);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                settings = line;
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public void setSettings(String settings, String setBools) throws IOException {
        FileWriter writer = new FileWriter(settingsPath + File.separator + settingsFile);
        String lineSeparator = System.getProperty("line.separator");
        writer.write(settings + lineSeparator);
        writer.write(setBools);
        writer.close();
        this.settings = settings;
    }
}
