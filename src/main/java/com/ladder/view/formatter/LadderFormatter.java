package com.ladder.view.formatter;

import com.ladder.model.LadderGame;
import com.ladder.model.Line;

import java.util.stream.Collectors;

public class LadderFormatter implements Formatter<LadderGame> {

    static final String LADDER_OF_COLUMNS = "|";
    public static final String LADDER_OF_EMPTY = "     ";
    static final String LADDER_OF_LINE = "-----";
    static final String LADDER_OF_FINISH = "\n";

    private final Formatter<Line> lineFormatter = new LineFormatter();

    @Override
    public String format(LadderGame ladderGame) {
        return ladderGame.getLadder().stream()
                .map(lineFormatter::format)
                .collect(Collectors.joining());
    }
}
