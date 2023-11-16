package me.namuhuchutong.ladder.domain.factory;

import me.namuhuchutong.ladder.domain.wrapper.LadderExpression;
import me.namuhuchutong.ladder.domain.wrapper.EmptySpace;
import me.namuhuchutong.ladder.domain.wrapper.Hyphen;

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
