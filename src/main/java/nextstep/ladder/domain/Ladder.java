package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.LinePoints;
import nextstep.ladder.domain.point.RandomPointGenerator;

public class Ladder {

    private List<Line> lines;
    private List<Player> players;
    private List<String> prize;

    public Ladder(List<Line> lines, List<Player> players) {
        validate(lines, players);

        this.lines = lines;
        this.players = players;
    }

    public Ladder(List<Line> lines, List<Player> players, List<String> prize) {
        validate(lines, players);

        this.lines = lines;
        this.players = players;
        this.prize = prize;
    }

    public static Ladder of(int height, List<String> names) {
        List<Player> players = names.stream()
            .map(Player::of).collect(Collectors.toList());

        List<Line> lines = Stream.generate(() -> new Line(
            LinePoints.of(players.size(), new RandomPointGenerator())))
            .limit(height)
            .collect(Collectors.toList());

        return new Ladder(lines, players);
    }

    private void validate(List<Line> lines, List<Player> players) {
        if (players.size() < 2) {
            throw new IllegalArgumentException("min player is 2");
        }
        if (lines.size() < 1) {
            throw new IllegalArgumentException("min height is 1");
        }
    }

    public List<Line> getLines() {
        return new ArrayList<>(this.lines);
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(this.players);
    }

    public String play(Player player) {
        int position = this.players.indexOf(player);

        for (Line line : this.lines) {
            position = line.move(position);
        }
        return this.prize.get(position);
    }
}
