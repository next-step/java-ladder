package nextstep.ladder.domain;

import nextstep.ladder.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {

    private final List<Player> players = new ArrayList<>();

    private Game() {

    }

    private Game(List<String> players, int ladderHeight) {

    }

    public static Game of(List<String> players, int ladderHeight) {
        return new Game(players, ladderHeight);
    }

    public static Game of(String playerNames, int ladderHeight) {
        return new Game(StringUtils.splitWithComma(playerNames), ladderHeight);
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
}
