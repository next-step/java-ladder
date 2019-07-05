package com.jaeyeonling.ladder.domain.line;

import com.jaeyeonling.ladder.domain.GameInfo;

import java.util.stream.Collectors;

public class GeneratorBaseLinesFactory implements LinesFactory {

    private final LineGenerator lineGenerator;

    private GeneratorBaseLinesFactory(final LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public static GeneratorBaseLinesFactory withLineGenerator(final LineGenerator lineGenerator) {
        return new GeneratorBaseLinesFactory(lineGenerator);
    }

    @Override
    public Lines create(final GameInfo gameInfo,
                        final HeightOfLadder heightOfLadder) {
        return heightOfLadder.rangeClosed()
                .mapToObj(ignore -> gameInfo.getCountOfUsers())
                .map(lineGenerator::generate)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lines::of));
    }
}
