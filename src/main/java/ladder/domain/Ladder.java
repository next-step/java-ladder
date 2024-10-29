package ladder.domain;

import ladder.exception.InvalidHeightOfLadderException;
import ladder.exception.InvalidNumberOfPlayersException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public static Ladder of(List<Line> lines) {
        return new Ladder(lines);
    }

    public static Ladder of(int heightOfLadder, int numberOfPlayers) {
        return new Ladder(createLadder(heightOfLadder, numberOfPlayers));
    }

    private static List<Line> createLadder(int heightOfLadder, int numberOfPlayers) {
        validateHeightOfLadder(heightOfLadder);
        validateNumberOfPlayers(numberOfPlayers);

        return IntStream.range(0, heightOfLadder)
                .mapToObj(i -> Line.of(numberOfPlayers, new RandomLineGenerator()))
                .collect(Collectors.toList());
    }

    private static void validateHeightOfLadder(int heightOfLadder) {
        if (heightOfLadder < 1) {
            throw new InvalidHeightOfLadderException();
        }
    }

    private static void validateNumberOfPlayers(int numberOfPlayers) {
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
