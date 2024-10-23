package ladder.domain;

import ladder.exception.InvalidHeightOfLadderException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private List<Line> lines;

    public Ladder(int heightOfLadder, int numberOfPlayers) {
        this.lines = createLadder(heightOfLadder, numberOfPlayers);
    }

    private List<Line> createLadder(int heightOfLadder, int numberOfPlayers) {
        if (heightOfLadder < 1) {
            throw new InvalidHeightOfLadderException();
        }

        return IntStream.range(0, heightOfLadder)
                .mapToObj(i -> new Line(numberOfPlayers))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }
}
