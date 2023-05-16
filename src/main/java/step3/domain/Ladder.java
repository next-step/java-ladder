package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(int countOfPlayers, int height) {
        this.ladder = createLadder(countOfPlayers, height);
    }

    private List<Line> createLadder(int countOfPlayers, int height) {
        List<Line> ladderList = new ArrayList<>();
        IntStream.range(0, height)
                .forEach(value -> ladderList.add(Line.createLine(countOfPlayers, new DirectionMoveStrategy())));
        return ladderList;
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
