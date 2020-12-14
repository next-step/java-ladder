package ladder.domain;

import java.util.Objects;

public class ClimbResult {

    private Player player;

    private Award award;

    private ClimbResult(Player player, Award award){
        this.player = player;
        this.award = award;
    }

    public static ClimbResult of(Player player, Award award){
        return new ClimbResult(player, award);
    }

    public Player getPlayer() {
        return player;
    }

    public Award getAward() {
        return award;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClimbResult that = (ClimbResult) o;
        return Objects.equals(player, that.player) &&
                Objects.equals(award, that.award);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, award);
    }
}
