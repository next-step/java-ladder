package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.LinePoints;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.PlayerPrize;
import nextstep.ladder.domain.point.RandomPointGenerator;

public class Ladder {

    private List<Line> lines;
    private List<Player> players;
    private List<String> prizes;

    Ladder(List<Line> lines, List<Player> players, List<String> prizes) {
        validate(lines, players);

        this.lines = lines;
        this.players = players;
        this.prizes = prizes;
    }

    public static Ladder of(int height, List<String> names, List<String> prizes) {
        List<Player> players = names.stream()
            .map(Player::of).collect(Collectors.toList());

        List<Line> lines = Stream.generate(() -> new Line(
            LinePoints.of(players.size(), new RandomPointGenerator())))
            .limit(height)
            .collect(Collectors.toList());

        return new Ladder(lines, players, prizes);
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

    public List<String> getPrizes() {
        return new ArrayList<>(this.prizes);
    }

    public PlayerPrize play(Player player) {
        int position = this.players.indexOf(player);

        for (Line line : this.lines) {
            position = line.move(position);
        }
        return PlayerPrize.of(player, this.prizes.get(position));
    }

    public List<PlayerPrize> play() {
        return this.players.stream()
            .map(this::play)
            .collect(Collectors.toList());
    }
}
