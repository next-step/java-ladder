package nextstep.model;

import java.util.Arrays;
import java.util.Objects;

public class Player {
    private final String player;

    public Player(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("사람의 이름은 최대5글자까지 부여할 수 있습니다.");
        }
        this.player = name;
    }

    public String player() {
        return this.player;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player1 = (Player) o;
        return Objects.equals(player, player1.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player);
    }
}
