package ru.zhbert.jscreenchanger.domain;

public class SettingsFileData {

    private int SCREENS_COUNT;

    private int FIRST_SCREEN_MIN;
    private int FIRST_SCREEN_MAX;
    private int FIRST_SCREEN_H_POS;
    private int FIRST_SCREEN_W_POS;

    private int SECOND_SCREEN_MIN;
    private int SECOND_SCREEN_MAX;
    private int SECOND_SCREEN_H_POS;
    private int SECOND_SCREEN_W_POS;

    private int THIRD_SCREEN_MIN;
    private int THIRD_SCREEN_MAX;
    private int THIRD_SCREEN_H_POS;
    private int THIRD_SCREEN_W_POS;

    public SettingsFileData() {
    }

    public SettingsFileData(int FIRST_SCREEN_MIN, int FIRST_SCREEN_MAX, int FIRST_SCREEN_H_POS, int FIRST_SCREEN_W_POS,
                            int SECOND_SCREEN_MIN, int SECOND_SCREEN_MAX, int SECOND_SCREEN_H_POS, int SECOND_SCREEN_W_POS,
                            int THIRD_SCREEN_MIN, int THIRD_SCREEN_MAX, int THIRD_SCREEN_H_POS, int THIRD_SCREEN_W_POS,
                            int SCREENS_COUNT) {
        this.FIRST_SCREEN_MIN = FIRST_SCREEN_MIN;
        this.FIRST_SCREEN_MAX = FIRST_SCREEN_MAX;
        this.FIRST_SCREEN_H_POS = FIRST_SCREEN_H_POS;
        this.FIRST_SCREEN_W_POS = FIRST_SCREEN_W_POS;
        this.SECOND_SCREEN_MIN = SECOND_SCREEN_MIN;
        this.SECOND_SCREEN_MAX = SECOND_SCREEN_MAX;
        this.SECOND_SCREEN_H_POS = SECOND_SCREEN_H_POS;
        this.SECOND_SCREEN_W_POS = SECOND_SCREEN_W_POS;
        this.THIRD_SCREEN_MIN = THIRD_SCREEN_MIN;
        this.THIRD_SCREEN_MAX = THIRD_SCREEN_MAX;
        this.THIRD_SCREEN_H_POS = THIRD_SCREEN_H_POS;
        this.THIRD_SCREEN_W_POS = THIRD_SCREEN_W_POS;
    }

    public int getFIRST_SCREEN_MIN() {
        return FIRST_SCREEN_MIN;
    }

    public void setFIRST_SCREEN_MIN(int FIRST_SCREEN_MIN) {
        this.FIRST_SCREEN_MIN = FIRST_SCREEN_MIN;
    }

    public int getFIRST_SCREEN_MAX() {
        return FIRST_SCREEN_MAX;
    }

    public void setFIRST_SCREEN_MAX(int FIRST_SCREEN_MAX) {
        this.FIRST_SCREEN_MAX = FIRST_SCREEN_MAX;
    }

    public int getFIRST_SCREEN_H_POS() {
        return FIRST_SCREEN_H_POS;
    }

    public void setFIRST_SCREEN_H_POS(int FIRST_SCREEN_H_POS) {
        this.FIRST_SCREEN_H_POS = FIRST_SCREEN_H_POS;
    }

    public int getFIRST_SCREEN_W_POS() {
        return FIRST_SCREEN_W_POS;
    }

    public void setFIRST_SCREEN_W_POS(int FIRST_SCREEN_W_POS) {
        this.FIRST_SCREEN_W_POS = FIRST_SCREEN_W_POS;
    }

    public int getSECOND_SCREEN_MIN() {
        return SECOND_SCREEN_MIN;
    }

    public void setSECOND_SCREEN_MIN(int SECOND_SCREEN_MIN) {
        this.SECOND_SCREEN_MIN = SECOND_SCREEN_MIN;
    }

    public int getSECOND_SCREEN_MAX() {
        return SECOND_SCREEN_MAX;
    }

    public void setSECOND_SCREEN_MAX(int SECOND_SCREEN_MAX) {
        this.SECOND_SCREEN_MAX = SECOND_SCREEN_MAX;
    }

    public int getSECOND_SCREEN_H_POS() {
        return SECOND_SCREEN_H_POS;
    }

    public void setSECOND_SCREEN_H_POS(int SECOND_SCREEN_H_POS) {
        this.SECOND_SCREEN_H_POS = SECOND_SCREEN_H_POS;
    }

    public int getSECOND_SCREEN_W_POS() {
        return SECOND_SCREEN_W_POS;
    }

    public void setSECOND_SCREEN_W_POS(int SECOND_SCREEN_W_POS) {
        this.SECOND_SCREEN_W_POS = SECOND_SCREEN_W_POS;
    }

    public int getTHIRD_SCREEN_MIN() {
        return THIRD_SCREEN_MIN;
    }

    public void setTHIRD_SCREEN_MIN(int THIRD_SCREEN_MIN) {
        this.THIRD_SCREEN_MIN = THIRD_SCREEN_MIN;
    }

    public int getTHIRD_SCREEN_MAX() {
        return THIRD_SCREEN_MAX;
    }

    public void setTHIRD_SCREEN_MAX(int THIRD_SCREEN_MAX) {
        this.THIRD_SCREEN_MAX = THIRD_SCREEN_MAX;
    }

    public int getTHIRD_SCREEN_H_POS() {
        return THIRD_SCREEN_H_POS;
    }

    public void setTHIRD_SCREEN_H_POS(int THIRD_SCREEN_H_POS) {
        this.THIRD_SCREEN_H_POS = THIRD_SCREEN_H_POS;
    }

    public int getTHIRD_SCREEN_W_POS() {
        return THIRD_SCREEN_W_POS;
    }

    public void setTHIRD_SCREEN_W_POS(int THIRD_SCREEN_W_POS) {
        this.THIRD_SCREEN_W_POS = THIRD_SCREEN_W_POS;
    }

    public int getSCREENS_COUNT() {
        return SCREENS_COUNT;
    }

    public void setSCREENS_COUNT(int SCREENS_COUNT) {
        this.SCREENS_COUNT = SCREENS_COUNT;
    }
}
