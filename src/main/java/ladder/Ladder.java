package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private List<Player> players;
    private List<Line> lines = new ArrayList<>();

    public Ladder(List<String> names, int height) {
        this.players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
        for (int i = 0; i < height; i++) {
            this.lines.add(new Line(players));
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        return "Ladder {\n" +
                "    players = " + players + ",\n" +
                "    lines = " + lines +
                "\n}";
    }
}
