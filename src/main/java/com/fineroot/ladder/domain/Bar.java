package com.fineroot.ladder.domain;

import com.fineroot.ladder.utils.ExceptionMessage;

public class Bar {

    private boolean havePreviousStep;
    private boolean haveStep;

    private Bar(final boolean hasPreviousStep, final boolean haveStep) {
        validation(hasPreviousStep, haveStep);
        this.haveStep = haveStep;
        this.havePreviousStep=hasPreviousStep;
    }

    private void validation(boolean hasPreviousStep, boolean haveStep) {
        if (hasPreviousStep && haveStep) {
            throw new IllegalArgumentException(ExceptionMessage.STEP_ROW_LINE_BOTH_TRUE.getMessage());
        }
    }
    public static Bar of(final boolean hasPreviousStep, final boolean haveStep) {
        return new Bar(hasPreviousStep, haveStep);
    }

    public boolean currentStep(){
        return haveStep;
    }

    public Direction move(){
        if(havePreviousStep){
            return Direction.LEFT;
        }
        if(haveStep){
            return Direction.RIGHT;
        }
        return Direction.PASS;
    }

    @Override
    public String toString() {
        if(haveStep){
            return "-----";
        }
        return "     ";
    }
}
