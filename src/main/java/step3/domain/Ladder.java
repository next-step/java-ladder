package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(int countOfPlayers, int height, MoveStrategy moveStrategy) {
        this.ladder = createLadder(countOfPlayers, height, moveStrategy);
    }

    private List<Line> createLadder(int countOfPlayers, int height, MoveStrategy moveStrategy) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, height)
                .forEach(value -> lines.add(Line.createLine(countOfPlayers, moveStrategy)));
        return lines;
    }

    public void getPosition(Position[] positions) {
        ladder.forEach(line -> {
            IntStream.range(0, line.size())
                    .forEach(idx -> {
                        positions[idx].position = positions[idx].move(line.getPoints().get(positions[idx].position));
                    });
        });
    }

    public Stream<Line> ladderStream() {
        return ladder.stream();
    }

    public void removeByIndex(int index) {
        ladder.remove(index);
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
