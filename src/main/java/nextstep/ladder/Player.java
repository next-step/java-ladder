package nextstep.ladder;

import java.util.Objects;

public class Player {

    private final UserName userName;

    public Player(UserName userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "" + userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(userName, player.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
