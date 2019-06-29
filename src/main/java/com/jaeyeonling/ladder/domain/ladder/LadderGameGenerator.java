package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.domain.line.LineGenerator;
public class LadderGameGenerator {

    private final LineGenerator lineGenerator;

    private LadderGameGenerator(final LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public static LadderGameGenerator of(final LineGenerator lineGenerator) {
        return new LadderGameGenerator(lineGenerator);
    }
}
