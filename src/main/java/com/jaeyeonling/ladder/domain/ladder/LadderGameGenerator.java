package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.domain.line.Line;
import com.jaeyeonling.ladder.domain.line.LineGenerator;
import com.jaeyeonling.ladder.domain.line.Lines;
import com.jaeyeonling.ladder.domain.user.Users;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameGenerator {

    private final LineGenerator lineGenerator;

    private LadderGameGenerator(final LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public static LadderGameGenerator of(final LineGenerator lineGenerator) {
        return new LadderGameGenerator(lineGenerator);
    }

    public LadderGame generate(final Users users,
                               final HeightOfLadder heightOfLadder) {
        final List<Line> rawLines = heightOfLadder.rangeClosed()
                .mapToObj(ignore -> users.getCountOfUsers())
                .map(lineGenerator::generate)
                .collect(Collectors.toList());

        final Lines lines = Lines.of(rawLines);

        return LadderGame.of(users, lines);
    }
}
