package ru.zhbert.jscreenchanger.domain;

public class Screen {

    private int width;

    private int height;

    private int screenNumber;

    private int heightHalf;

    private int widthHalf;

    public Screen() {
    }

    public Screen(int width, int height, int screenNumber) {
        this.width = width;
        this.height = height;
        this.screenNumber = screenNumber;

        this.heightHalf = this.height/2;
        this.widthHalf = this.width/2;
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
}
