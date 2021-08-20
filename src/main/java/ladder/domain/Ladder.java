package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final List<Player> players;
    private final List<Line> lines = new ArrayList<>();
    private final List<String> results = new ArrayList<>();

    public Ladder(List<String> names, int height, List<String> result) {
        this.players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
        for (int i = 0; i < height; i++) {
            this.lines.add(new Line(players));
        }
        this.results.addAll(result);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        return "Ladder {" +
                "    players = " + players + ",\n" +
                "    lines = " + lines + ",\n" +
                "    results = " + results + "\n" +
                '}';
    }
}
