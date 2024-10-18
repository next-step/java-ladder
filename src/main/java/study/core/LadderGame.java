package study.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderGame {
    private final List<PlayerName> names;
    private final int height;

    public LadderGame(List<PlayerName> names, int height) {
        this.names = names;
        this.height = height;
    }

    public List<Line> createLadder() {
        List<Line> ladder = new ArrayList<>();
        IntStream.range(0, height).forEach(i -> {
            Line line = new Line(new ArrayList<>());
            line.createPoints(names.size());
            ladder.add(line);
        });
        return ladder;
    }

}
