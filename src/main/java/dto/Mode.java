package dto;

import utils.Generator;

import java.util.Arrays;

public enum Mode {

    NORMAL("하" , 5 , 20),
    HARDCORE("중", 10 , 50),
    HELL("상", 20 , 100);

//    private static final int HELL_LEVEL = 80;
//    private static final int HARDCORE_LEVEL = 50;
//    private static final int NORMAL_LEVEL = 20;

    private String level;
    private int lineCount;
    private int percentage;

    Mode(String level, int lineCount, int percentage) {
        this.level = level;
        this.lineCount = lineCount;
        this.percentage = percentage;
    }

    Mode(String level, int lineCount) {
        this.level = level;
        this.lineCount = lineCount;
    }

    public int getLineCount() {
        return lineCount;
    }
/*
    derpecated

    public static Mode find(String level) {
        for (Mode mode : Mode.values()){
            if(mode.level == level){
                return mode;
            }
        }
        return Mode.ERROR;
    }
    */

    public static boolean drawLineByPercentage(Mode mode) {
        if(Generator.difficultyRandom() < mode.percentage)
            return true;
        return false;
    }

    public static Mode find(String level){
        return Arrays.stream(Mode.values()).filter(e -> e.level.equals(level)).findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
