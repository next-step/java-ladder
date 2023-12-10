package com.fineroot.ladder.domain;

import com.fineroot.ladder.engine.Bar;
import com.fineroot.ladder.engine.BarCreator;

public class MyBarCreator implements BarCreator {
    @Override
    public Bar create(boolean hasPreviousStep, boolean haveNextStep) {
        return new MyBar(hasPreviousStep, haveNextStep);
    }



}
