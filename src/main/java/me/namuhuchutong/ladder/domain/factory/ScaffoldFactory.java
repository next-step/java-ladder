package me.namuhuchutong.ladder.domain.factory;

import me.namuhuchutong.ladder.domain.wrapper.LadderExpressionEnum;

@FunctionalInterface
public interface ScaffoldFactory {

    LadderExpressionEnum createScaffold();
}
