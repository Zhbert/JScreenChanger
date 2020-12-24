package ru.zhbert.jscreenchanger.service;

import ru.zhbert.jscreenchanger.domain.Screen;
import ru.zhbert.jscreenchanger.domain.ScreenChanger;

import java.io.*;
import java.util.ArrayList;

public class SettingsFileService {

    final private String settingsPath = System.getProperty("user.home") + File.separator + ".jscreenchanger";

    final private String settingsFile = "jscreenchanger.conf";

    private String screenPositions = null;
    private String screenDirection = null;

    public SettingsFileService() throws IOException {
        File file = new File(settingsPath);
        if (!file.exists()) {
            file.mkdir();
        }

        file = new File(settingsPath + File.separator + settingsFile);
        if (file.createNewFile()) {
            System.out.println("Settings file is created!");
        } else {
            System.out.println("Settings file is founded.");
        }

        System.out.println(file.toURI());
    }

    public boolean readSettings() {
        try {
            File file = new File(settingsPath + File.separator + settingsFile);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            for (int counter = 0; counter < 2; counter++) {
                String line = reader.readLine();
                if (counter == 0) {
                    screenPositions = line;
                } else {
                    screenDirection = line;
                    return true;
                }
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
        this.screenPositions = settings;
    }

    public ArrayList<ScreenChanger> setScreenChangers(ArrayList<Screen> screenPool) {
        ArrayList<ScreenChanger> screenChangers = new ArrayList<>();
        String[] screens = this.screenPositions.split(" ");
        String[] directions = this.screenDirection.split(" ");

        //Parse settings file
        int counter = 0;
        ArrayList<Integer> screenNumbers = new ArrayList<>();
        ArrayList<Boolean> screenDirections = new ArrayList<>();
        for (String str : screens) {
            screenNumbers.add(Integer.parseInt(str));
            screenDirections.add(Boolean.parseBoolean(directions[counter]));
            counter++;
        }

        //Generate new screens pool
        counter = 0;
        for (int i : screenNumbers) {
            for (int y = 0; y < screenPool.size(); y++) {
                ScreenChanger screenChanger = new ScreenChanger();
                if (screenPool.get(y).getScreenNumber() == i) {
                    screenChanger.setScreen(screenPool.get(y));
                    screenChanger.setDirection(screenDirections.get(i));
                    screenChanger.setPosition(screenChanger.getScreen().getWidth() / 2);
                    screenChangers.add(screenChanger);
                }
                counter++;
            }
        }

        //Generate next changers
        for (int i = 0; i < screenChangers.size(); i++) {
            if (i + 1 <= screenChangers.size() - 1) {
                screenChangers.get(i).setNextScreenChanger(screenChangers.get(i + 1));
            } else screenChangers.get(i).setNextScreenChanger(screenChangers.get(0));
        }

        //Generate positions
        boolean isFirst = true;
        for (int i = 0; i < screenChangers.size(); i++) {
            if (i + 1 <= screenChangers.size() - 1) {
                if (isFirst) {
                    screenChangers.get(i).setPosition(screenChangers.get(i).getPosition()-(screenChangers.get(i).getPosition()*2));
                    isFirst = false;
                }
                if (screenChangers.get(i + 1).getDirection()) {
                        screenChangers.get(i).setPosition(screenChangers.get(i).getPosition() -
                                screenChangers.get(i + 1).getScreen().getWidth());
                        counter = i + 1;
                        System.out.println("Set: " + screenChangers.get(i).getPosition());
                }
            }
        }
        for (int i = screenChangers.size() - 1; i >= counter; i--) {
            if (i - 1 >= 0) {
                if (i == screenChangers.size() - 1) {
                    for (int y = i-1; y >= counter; y--) {
                        screenChangers.get(i).setPosition(screenChangers.get(i).getPosition()+screenChangers.get(y).getPosition());
                    }
                }
            }
        }


        for (ScreenChanger scch : screenChangers) {
            System.out.println("_______________________________________________________");
            System.out.println("Screen number: " + scch.getScreen().getScreenNumber());
            System.out.println("Position: " + scch.getPosition());
            System.out.println("Max position: " + scch.getMaxPosition());
            System.out.println("Min position: " + scch.getMinPosition());
            System.out.println("Next Screen number: " + scch.getNextScreenChanger().getScreen().getScreenNumber());
            System.out.println("Next screen position: " + scch.getNextScreenChanger().getPosition());
            System.out.println("_______________________________________________________");
        }
        return screenChangers;
    }

    public String getScreenPositions() {
        return screenPositions;
    }

    public String getScreenDirection() {
        return screenDirection;
    }
}
