package com.fineroot.ladder.domain;

import com.fineroot.ladder.utils.ExceptionMessage;

public class Bar {
    private boolean haveStep;

    private Bar(final boolean hasPreviousStep, final boolean haveStep) {
        validation(hasPreviousStep, haveStep);
        this.haveStep = haveStep;
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

    @Override
    public String toString() {
        if(haveStep){
            return "-----";
        }
        return "     ";
    }
}
