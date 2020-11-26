package ru.zhbert.jscreenchanger;

import ru.zhbert.jscreenchanger.domain.Screen;
import ru.zhbert.jscreenchanger.service.HotKeyService;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws AWTException, InterruptedException {

        ArrayList<Screen> screenPool = new ArrayList<Screen>();

        HotKeyService hotKeyService = new HotKeyService();
        hotKeyService.start();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        Robot robot = new Robot();
        robot.mouseMove(screenWidth/2, screenHeight/2);

        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = environment.getScreenDevices();
        System.out.println("Screens found: " + devices.length);
        for (int i=0; i<devices.length; i++) {
            DisplayMode displayMode = devices[i].getDisplayMode();
            screenPool.add(new Screen(displayMode.getWidth(), displayMode.getHeight(), i));
        }

        for (Screen screen : screenPool) {
            System.out.println("Parameters of " + screen.getScreenNumber() + " monitor:");
            System.out.println("Number: " + screen.getScreenNumber());
            System.out.println("Width: " + screen.getWidth());
            System.out.println("Height: " + screen.getHeight());
        }
/*
        while (true) {
            System.out.println(MouseInfo.getPointerInfo().getLocation().getX() + " " + MouseInfo.getPointerInfo().getLocation().getY());
            Thread.sleep(1000);
        }
        */

        Scanner in = new Scanner(System.in);
        System.out.print("Input a command: ");
        int num = in.nextInt();
        hotKeyService.stop();
        System.out.printf("Your number: %d \n", num);
        in.close();

    }
}
