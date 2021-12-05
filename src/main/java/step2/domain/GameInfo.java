package step2.domain;

import java.util.Objects;

public class GameInfo {
    private final Participants participants;
    private final Rewards rewards;

    private GameInfo(Participants participants, Rewards rewards) {
        this.participants = participants;
        this.rewards = rewards;
    }

    public static GameInfo of(Participants participants, Rewards rewards) {
        validateMatchSize(participants.matchedSize(rewards.size()));
        return new GameInfo(participants, rewards);
    }

    public Participants participants() {
        return participants;
    }

    public Rewards rewards() {
        return rewards;
    }

    private static void validateMatchSize(boolean matched) {
        if (!matched) {
            throw new IllegalArgumentException("참가자 수와 보상의 수가 일치하지 않습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameInfo gameInfo = (GameInfo) o;
        return Objects.equals(participants, gameInfo.participants) && Objects.equals(rewards, gameInfo.rewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participants, rewards);
    }
}
