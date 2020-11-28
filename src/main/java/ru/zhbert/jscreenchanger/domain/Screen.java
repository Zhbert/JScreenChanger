package ru.zhbert.jscreenchanger.domain;

import java.awt.*;

public class Screen {

    private int width;

    private int height;

    private int screenNumber;

    private int heightHalf;

    private int widthHalf;

    private GraphicsDevice graphicsDevice;

    public Screen() {
    }

    public Screen(int width, int height, int screenNumber, GraphicsDevice graphicsDevice) {
        this.width = width;
        this.height = height;
        this.screenNumber = screenNumber;
        this.graphicsDevice = graphicsDevice;

        this.heightHalf = this.height/2;
        this.widthHalf = this.width/2;
    }

    @Override
    public String toString() {
        return "Screen number: " + this.screenNumber +
                "; Width: " + this.width +
                "; Height: " + this.height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getScreenNumber() {
        return screenNumber;
    }

    public void setScreenNumber(int screenNumber) {
        this.screenNumber = screenNumber;
    }

    public int getHeightHalf() {
        return heightHalf;
    }

    public void setHeightHalf(int heightHalf) {
        this.heightHalf = heightHalf;
    }

    public int getWidthHalf() {
        return widthHalf;
    }

    public void setWidthHalf(int widthHalf) {
        this.widthHalf = widthHalf;
    }

    public GraphicsDevice getGraphicsDevice() {
        return graphicsDevice;
    }

    public void setGraphicsDevice(GraphicsDevice graphicsDevice) {
        this.graphicsDevice = graphicsDevice;
    }
}
