package me.namuhuchutong.ladder.domain.factory;

import me.namuhuchutong.ladder.domain.wrapper.LadderExpression;

@FunctionalInterface
public interface ScaffoldFactory {

    LadderExpression createScaffold();
}
