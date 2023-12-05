package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private static final Random random = new Random();
    private final Players players;
    private final List<Line> lines;

    private Ladder(Players players, List<Line> lines) {
        this.players = players;
        this.lines = lines;
    }

    public static Ladder of(List<String> playerNames, int height) {
        return new Ladder(Players.fromString(playerNames), initLines(playerNames, height));
    }

    private static List<Line> initLines(List<String> playerNames, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(playerNames.size(), random::nextBoolean));
        }
        return lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<String> toStringPlayers() {
        return this.players.toStringList();
    }

}
