package me.namuhuchutong.ladder.domain.factory;

import me.namuhuchutong.ladder.domain.wrapper.LadderExpression;

import java.util.Random;

import static me.namuhuchutong.ladder.domain.wrapper.LadderExpression.*;

public class ScaffoldRandomFactory implements ScaffoldFactory {

    private static final Random RANDOM = new Random();

    private boolean createdBefore;

    public ScaffoldRandomFactory() {
        this.createdBefore = false;
    }

    public LadderExpression createScaffold() {
        if (RANDOM.nextBoolean() && !createdBefore) {
            createdBefore = true;
            return HYPHEN;
        }
        createdBefore = false;
        return EMPTY_SPACE;
    }
}
