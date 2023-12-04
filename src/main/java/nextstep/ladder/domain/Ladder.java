package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final List<String> players;
    private final List<Line> lines = new ArrayList<>();

    public Ladder(List<String> players, int height, LineStrategy lineStrategy) {
        Random random = new Random();
        this.players = players;
        for (int i = 0; i < height; i++) {
            lines.add(new Line(players.size(), lineStrategy));
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<String> getPlayers() {
        return players;
    }
}
