package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Line;
import nextstep.ladder.exception.OutOfRangeException;
import nextstep.ladder.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Game {

    private static final int MIN_LADDER_HEIGHT = 1;

    private List<Line> lines = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

    private Game() {

    }

    private Game(List<Player> players, List<Line> lines) {
        validateLadderHeight(lines.size());

        this.players = players;
        this.lines = lines;
    }

    public static Game of(List<Player> players, List<Line> lines) {
        return new Game(players, lines);
    }

    public static Game of(String playerNames, List<Line> lines) {
        return new Game(
                StringUtils.splitWithComma(playerNames).stream()
                        .map(Player::from)
                        .collect(Collectors.toList())
                , lines);
    }

    private void validateLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw OutOfRangeException.shouldGreaterOrEqualThan(ladderHeight, MIN_LADDER_HEIGHT);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return Objects.equals(players, game.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    @Override
    public String toString() {

        return players.stream()
                .map(Player::toString)
                .collect(Collectors.joining(" ")) +
                "\n" +
                lines.stream()
                        .map(Line::toString)
                        .collect(Collectors.joining("\n"));
    }
}
