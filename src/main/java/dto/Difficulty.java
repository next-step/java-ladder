package dto;

import utils.Generator;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Difficulty {

    NORMAL("하" , 5 , 20),
    HARDCORE("중", 10 , 50),
    HELL("상", 20 , 80),
    ERROR("로또확률" , 0);

//    private static final int HELL_LEVEL = 80;
//    private static final int HARDCORE_LEVEL = 50;
//    private static final int NORMAL_LEVEL = 20;

    private String level;
    private int lineCount;
    private int percentage;

    Difficulty(String level, int lineCount, int percentage) {
        this.level = level;
        this.lineCount = lineCount;
        this.percentage = percentage;
    }

    Difficulty(String level, int lineCount) {
        this.level = level;
        this.lineCount = lineCount;
    }

    public int getLineCount() {
        return lineCount;
    }
/*
    derpecated

    public static Difficulty find(String level) {
        for (Difficulty difficulty : Difficulty.values()){
            if(difficulty.level == level){
                return difficulty;
            }
        }
        return Difficulty.ERROR;
    }
    */

    public static boolean drawLineByPercentage(Difficulty difficulty) {
        if(Generator.difficultyRandom() <difficulty.percentage)
            return true;
        return false;
    }

    public static Difficulty find(String level){
        return Arrays.stream(Difficulty.values()).filter(e -> e.level.equals(level)).findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
