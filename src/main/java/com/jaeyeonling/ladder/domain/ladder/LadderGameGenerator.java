package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.domain.GameInfo;
import com.jaeyeonling.ladder.domain.line.LineGenerator;
import com.jaeyeonling.ladder.domain.line.Lines;

import java.util.stream.Collectors;

public class LadderGameGenerator {

    private final LineGenerator lineGenerator;

    private LadderGameGenerator(final LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public static LadderGameGenerator withLineGenerator(final LineGenerator lineGenerator) {
        return new LadderGameGenerator(lineGenerator);
    }

    public LadderGame generate(final GameInfo gameInfo,
                               final HeightOfLadder heightOfLadder) {
        final Lines lines = heightOfLadder.rangeClosed()
                .mapToObj(ignore -> gameInfo.getCountOfUsers())
                .map(lineGenerator::generate)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lines::of));

        return LadderGame.of(gameInfo, lines);
    }
}
