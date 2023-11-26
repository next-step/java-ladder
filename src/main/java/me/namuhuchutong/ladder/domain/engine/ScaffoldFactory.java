package me.namuhuchutong.ladder.domain.engine;

import me.namuhuchutong.ladder.domain.implement.wrapper.LadderExpression;

@FunctionalInterface
public interface ScaffoldFactory {

    LadderExpression createScaffold();
}
