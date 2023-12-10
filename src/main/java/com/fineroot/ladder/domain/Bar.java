package com.fineroot.ladder.domain;

import com.fineroot.ladder.utils.ExceptionMessage;

public class Bar {

    private boolean havePreviousStep;
    private boolean haveNextStep;

    private Bar(final boolean hasPreviousStep, final boolean haveNextStep) {
        validation(hasPreviousStep, haveNextStep);
        this.haveNextStep = haveNextStep;
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
        return haveNextStep;
    }

    public Position move(Position position){
        if(havePreviousStep){
            return Direction.LEFT.move(position);
        }
        if(haveNextStep){
            return Direction.RIGHT.move(position);
        }
        return Direction.PASS.move(position);
    }

    @Override
    public String toString() {
        if(haveNextStep){
            return "|-----";
        }
        return "|     ";
    }
}
