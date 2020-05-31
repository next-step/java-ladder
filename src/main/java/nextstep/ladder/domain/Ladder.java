package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.LinePointFactory;
import nextstep.ladder.domain.point.RandomPointGenerator;

public class Ladder {

    private List<Line> lines;
    private List<Player> players;

    private Ladder(int height, List<Player> players) {
        if (players.size() < 2) {
            throw new IllegalArgumentException("min player is 2");
        }
        if (height < 1) {
            throw new IllegalArgumentException("min height is 1");
        }

        this.lines = Stream.generate(() -> new Line(
            LinePointFactory.of(players.size(), new RandomPointGenerator())))
            .limit(height)
            .collect(Collectors.toList());

        this.players = players;
    }

    public static Ladder of(int height, List<String> names) {
        List<Player> players = names.stream()
            .map(Player::of).collect(Collectors.toList());

        return new Ladder(height, players);
    }

    public List<Line> getLines() {
        return new ArrayList<>(this.lines);
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(this.players);
    }
}
