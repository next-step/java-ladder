package study.core;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final List<PlayerName> names;
    private final int height;

    public LadderGame(List<PlayerName> names, int height) {
        this.names = names;
        this.height = height;
    }

    public List<Line> createLadder() {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Line line = new Line(new ArrayList<>());
            line.createPoints(names.size());
            ladder.add(line);
        }
        return ladder;
    }

}
