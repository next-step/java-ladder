package com.fineroot.ladder.engine;

public interface BarCreator {
    Bar create(final boolean hasPreviousStep, final boolean haveNextStep);
}
