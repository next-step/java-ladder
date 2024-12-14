package ladder.domain.impl;

import ladder.domain.engine.Ladder;
import ladder.domain.engine.LadderCreator;
import ladder.domain.engine.Line;
import ladder.domain.engine.LineGenerator;
import ladder.exception.InvalidHeightOfLadderException;
import ladder.exception.InvalidNumberOfPlayersException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderCreatorImpl implements LadderCreator {

    private LineGenerator lineGenerator;

    public LadderCreatorImpl(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    @Override
    public Ladder create(int heightOfLadder, int numberOfPlayers) {
        validateHeightOfLadder(heightOfLadder);
        validateNumberOfPlayers(numberOfPlayers);

        List<Line> lines = IntStream.range(0, heightOfLadder)
                .mapToObj(i -> LineImpl.of(numberOfPlayers, lineGenerator))
                .collect(Collectors.toList());

        return LadderImpl.of(lines);
    }

    private void validateHeightOfLadder(int heightOfLadder) {
        if (heightOfLadder < 1) {
            throw new InvalidHeightOfLadderException();
        }
    }

    private void validateNumberOfPlayers(int numberOfPlayers) {
        if (numberOfPlayers < 1) {
            throw new InvalidNumberOfPlayersException();
        }
    }
}
