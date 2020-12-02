package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PlayerRewardMatches {
    private final List<PlayerRewardMatch> playerRewardMatches;

    private PlayerRewardMatches(final List<PlayerRewardMatch> playerRewardMatches) {
        this.playerRewardMatches = playerRewardMatches;
    }

    public static PlayerRewardMatches of(final List<PlayerRewardMatch> playerRewardMatches) {
        return new PlayerRewardMatches(playerRewardMatches);
    }

    public List<PlayerRewardMatch> getPlayerRewardMatches() {
        return Collections.unmodifiableList(playerRewardMatches);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerRewardMatches that = (PlayerRewardMatches) o;
        return Objects.equals(playerRewardMatches, that.playerRewardMatches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerRewardMatches);
    }
}
