package ladder.domain.ladder;

import ladder.domain.user.LadderPlayers;

import java.util.Objects;

public class LadderComponentDto {

    private final LadderPlayers players;
    private final LadderHeight height;

    public LadderComponentDto(LadderPlayers players, LadderHeight height) {
        this.players = players;
        this.height = height;
    }

    public LadderPlayers getPlayers() {
        return players;
    }

    public int getHeight() {
        return height.getHeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderComponentDto that = (LadderComponentDto) o;
        return Objects.equals(players, that.players) && Objects.equals(height, that.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players, height);
    }

    @Override
    public String toString() {
        return "LadderComponentDto{" +
                "players=" + players +
                ", height=" + height +
                '}';
    }

}
