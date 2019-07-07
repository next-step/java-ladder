package ladder.view.constant;

import java.util.Arrays;

public enum Step {
    EMPTY_STEP(0),
    GAMERS_STEP(1),
    REWARD_INPUT_STEP(2),
    LADDER_SIZE_STEP(3),
    RESULT_STEP(4),
    GAMER_NAME_INPUT_STEP(5),
    REWARD_STEP(6);
    
    public static Step thisStep = GAMERS_STEP;
    
    private int step;
    
    public static boolean isThisStep(Step step) {
        return thisStep == step;
    }
    
    public static void setNextStep(Step step) {
        thisStep = step;
    }
    
    private static Step getNextStep(Step step) {
        return findStep(step.getStep() + 1);
    }
    
    private static Step findStep(int i) {
        return Arrays.stream(values())
          .filter(step -> step.getStep() == i)
          .findFirst()
          .orElse(EMPTY_STEP);
    }
    
    Step(int step) {
        this.step = step;
    }
    
    private int getStep() {
        return step;
    }
}
