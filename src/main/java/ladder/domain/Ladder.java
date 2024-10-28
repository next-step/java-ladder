package ladder.domain;

import ladder.exception.InvalidHeightOfLadderException;
import ladder.exception.InvalidNumberOfPlayersException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int heightOfLadder, int numberOfPlayers) {
        this.lines = createLadder(heightOfLadder, numberOfPlayers);
    }

    private List<Line> createLadder(int heightOfLadder, int numberOfPlayers) {
        validateHeightOfLadder(heightOfLadder);
        validateNumberOfPlayers(numberOfPlayers);

        return IntStream.range(0, heightOfLadder)
                .mapToObj(i -> new Line(numberOfPlayers, new RandomLineGenerator()))
                .collect(Collectors.toList());
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

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public int move(int startPosition) {
        int position = startPosition;
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }
}
