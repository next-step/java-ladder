package com.fineroot.ladder.domain;

public class Step {

    private Bar bar;
    private Step(final Bar bar){
        this.bar = bar;
    }

    public static Step from(final Bar bar){
        return new Step(bar);
    }

    public Bar next(final boolean haveStep){
        return bar.next(haveStep);
    }

    public Bar last(){
        return bar.last();
    }

    public boolean canNextTrue(){
        return !bar.currentStep();
    }

    @Override
    public String toString() {
        return bar.toString();
    }
}
