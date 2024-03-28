package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Line> lines;
    private final List<Player> players;

    public Ladder(List<Player> players, int height) {
        this.lines = players.stream()
                .map(name -> new Line(name, height))
                .collect(Collectors.toList());
        this.players = players;
    }

    public void play() {
        for (Line line : lines) {

        }
    }
}
