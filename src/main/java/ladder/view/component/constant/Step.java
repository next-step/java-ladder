package ladder.view.component.constant;

public enum Step {
    GAMERS_STEP(1),
    REWARD_INPUT_STEP(2),
    LADDER_SIZE_STEP(3),
    RESULT_STEP(4),
    GAMER_NAME_INPUT_STEP(5),
    REWARD_STEP(6);
    
    public static Step THIS_STEP = GAMERS_STEP;
    
    private int step;
    
    Step(int step) {
        this.step = step;
    }

    public static boolean isThisStep(Step step) {
        return THIS_STEP == step;
    }
    
    public static void setNextStep(Step step) {
        THIS_STEP = step;
    }
}
