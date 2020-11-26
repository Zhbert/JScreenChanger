package ru.zhbert.jscreenchanger;

import ru.zhbert.jscreenchanger.domain.Screen;

import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws AWTException {

        ArrayList<Screen> screenPool = new ArrayList<Screen>();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        Robot robot = new Robot();
        robot.mouseMove(screenWidth/2, screenHeight/2);

        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = environment.getScreenDevices();
        System.out.println("Screens found: " + devices.length);
        for (int i=0; i<devices.length; i++) {
            DisplayMode dmode = devices[i].getDisplayMode();
            screenPool.add(new Screen(dmode.getWidth(), dmode.getHeight(), i));
        }

        for (Screen screen : screenPool) {
            System.out.println("Parameters of " + screen.getScreenNumber() + " monitor:");
            System.out.println("Number: " + screen.getScreenNumber());
            System.out.println("Width: " + screen.getWidth());
            System.out.println("Height: " + screen.getHeight());
        }
    }
}
