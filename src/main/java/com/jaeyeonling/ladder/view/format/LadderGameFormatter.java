package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.ladder.LadderGame;
import com.jaeyeonling.ladder.domain.line.Lines;

public class LadderGameFormatter implements Formatter<LadderGame> {

    private final Formatter<Lines> linesFormatter;

    private LadderGameFormatter(final Formatter<Lines> linesFormatter) {
        this.linesFormatter = linesFormatter;
    }

    public static LadderGameFormatter withLinesFormatter(final Formatter<Lines> linesFormatter) {
        return new LadderGameFormatter(linesFormatter);
    }

    @Override
    public String format(final LadderGame ladderGame) {
        return linesFormatter.format(ladderGame.getLines());
    }
}
