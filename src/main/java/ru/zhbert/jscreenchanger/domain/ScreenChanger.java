package ru.zhbert.jscreenchanger.domain;

public class ScreenChanger {

    private Screen screen;
    private int position;
    private int nextNumber;
    private ScreenChanger nextScreenChanger;
    private boolean direction;
    private int maxPosition;
    private int minPosition;

    public ScreenChanger(Screen screen, int position, int nextNumber, ScreenChanger nextScreenChanger, boolean direction) {
        this.screen = screen;
        this.position = position;
        this.nextNumber = nextNumber;
        this.nextScreenChanger = nextScreenChanger;
        this.direction = direction;
    }

    public ScreenChanger() {
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
        this.maxPosition = position + this.screen.getWidth()/2;
        this.minPosition = position - this.screen.getWidth()/2;
    }

    public int getNextNumber() {
        return nextNumber;
    }

    public void setNextNumber(int nextNumber) {
        this.nextNumber = nextNumber;
    }

    public ScreenChanger getNextScreenChanger() {
        return nextScreenChanger;
    }

    public void setNextScreenChanger(ScreenChanger nextScreenChanger) {
        this.nextScreenChanger = nextScreenChanger;
    }

    public boolean getDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public int getMaxPosition() {
        return maxPosition;
    }

    public void setMaxPosition(int maxPosition) {
        this.maxPosition = maxPosition;
    }

    public int getMinPosition() {
        return minPosition;
    }

    public void setMinPosition(int minPosition) {
        this.minPosition = minPosition;
    }
}
