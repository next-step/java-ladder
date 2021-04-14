package nextstep.ladder.domain;

import java.util.Objects;

public class CountOfPlayer {
    private final int countOfPlayer;

    public CountOfPlayer(int countOfPlayer) {
        this.countOfPlayer = countOfPlayer;
    }

    public int number() {
        return countOfPlayer;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountOfPlayer that = (CountOfPlayer) o;
        return countOfPlayer == that.countOfPlayer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfPlayer);
    }
}
