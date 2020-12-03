package ru.zhbert.jscreenchanger.domain;

public class ScreenChanger {

    private Screen screen;
    private int position;
    private int nextNumber;
    private ScreenChanger nextScreenChanger;
    private boolean direction;

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

    public boolean isDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }
}
