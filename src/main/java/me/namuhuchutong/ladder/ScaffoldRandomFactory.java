package me.namuhuchutong.ladder;

import java.util.Random;

public class ScaffoldRandomFactory implements ScaffoldFactory {

    private static final Random RANDOM = new Random();

    private boolean createdBefore;

    public ScaffoldRandomFactory() {
        this.createdBefore = false;
    }

    public LadderExpression createScaffold() {
        if (RANDOM.nextBoolean() && !createdBefore) {
            createdBefore = true;
            return new Hyphen();
        }
        createdBefore = false;
        return new EmptySpace();
    }
}
