package com.fineroot.ladder.domain;

import com.fineroot.ladder.utils.ExceptionMessage;

public class Bar {
    private boolean hasPreviousStep;
    private boolean haveStep;

    private Bar(final boolean hasPreviousStep, final boolean haveStep) {
        validation(hasPreviousStep, haveStep);
        this.hasPreviousStep = hasPreviousStep;
        this.haveStep = haveStep;
    }

    private void validation(boolean hasPreviousStep, boolean haveStep) {
        if (hasPreviousStep && haveStep) {
            throw new IllegalArgumentException(ExceptionMessage.STEP_ROW_LINE_BOTH_TRUE.getMessage());
        }
    }

    public static Bar first(final boolean haveStep) {
        return new Bar(false, haveStep);
    }

    public Bar next(final boolean haveStep) {
        return new Bar(this.haveStep, haveStep);
    }

    public Bar last() {
        return new Bar(this.haveStep, false);
    }

    public boolean currentStep(){
        return haveStep;
    }

    @Override
    public String toString() {
        if(haveStep){
            return "-";
        }
        return " ";
    }
}
