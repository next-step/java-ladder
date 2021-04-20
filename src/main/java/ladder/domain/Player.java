package ladder.domain;

import ladder.view.ResultView;

import java.util.Objects;
import java.util.stream.IntStream;

public class Player {
    private final String player;

    public Player(String player) {
        this.player = player;
    }

    public String withWhiteSpacePlayer() {
        if (player.length() > ResultView.AISLE_WIDTH + 1) {
            return "";
        }
        int nullSpace = ResultView.AISLE_WIDTH + 1 - player.length();
        StringBuilder sb = new StringBuilder();
        sb.append(player);
        IntStream.rangeClosed(0, nullSpace)
                .forEach(i -> sb.append(" "));
        return sb.toString();
    }

    @Override
    public String toString() {
        return player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player1 = (Player) o;
        return Objects.equals(player, player1.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player);
    }
}
