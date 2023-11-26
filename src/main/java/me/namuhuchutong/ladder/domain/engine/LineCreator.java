package me.namuhuchutong.ladder.domain.engine;

public interface LineCreator {

    Line createLine(int participants, ScaffoldFactory factory);
}
