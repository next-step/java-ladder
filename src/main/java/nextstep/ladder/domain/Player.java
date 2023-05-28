package nextstep.ladder.domain;

import java.util.Objects;

public class Player {
    private final PlayerName name;

    private Result result;

    private final int startPosition;

    public Player(PlayerName name, int startPosition) {
        this.name = name;
        this.startPosition = startPosition;
    }

    public PlayerName getName() {
        return name;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void saveResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

}
