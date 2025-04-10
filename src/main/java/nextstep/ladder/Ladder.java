package nextstep.ladder;

import nextstep.ladder.player.Players;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private List<Line> lines;
    private Players players;

    public Ladder(Height height, Players players) {
        this.lines = createLines(height.getValue(), players.size());
        this.players = players;
    }

    private List<Line> createLines(int height, int personCount) {
        return Stream.generate(() -> new Line(personCount - 1))
                .limit(height)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : lines) {
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString();
    }

    public Players getPlayers() {
        return players;
    }
}
