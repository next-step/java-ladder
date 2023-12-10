package com.fineroot.ladder.domain;

import com.fineroot.ladder.engine.Bar;
import com.fineroot.ladder.engine.Position;
import com.fineroot.ladder.utils.ExceptionMessage;

public class MyBar implements Bar {

    private final boolean havePreviousStep;
    private final boolean haveNextStep;

    MyBar(final boolean hasPreviousStep, final boolean haveNextStep) {
        validation(hasPreviousStep, haveNextStep);
        this.haveNextStep = haveNextStep;
        this.havePreviousStep=hasPreviousStep;
    }

    private void validation(boolean hasPreviousStep, boolean haveStep) {
        if (hasPreviousStep && haveStep) {
            throw new IllegalArgumentException(ExceptionMessage.STEP_ROW_LINE_BOTH_TRUE.getMessage());
        }
    }

    @Override
    public boolean currentStep(){
        return haveNextStep;
    }

    @Override
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
