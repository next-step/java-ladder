package nextstep.ladder.domain;

import java.util.Objects;

public class LadderGameResult {
    private final Participant participant;
    private final Reward reward;

    public LadderGameResult(Participant participant, Reward reward) {
        this.participant = participant;
        this.reward = reward;
    }

    public Reward getReward() {
        return reward;
    }

    public Participant getParticipant() {
        return participant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderGameResult that = (LadderGameResult) o;
        return Objects.equals(participant, that.participant) && Objects.equals(reward, that.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participant, reward);
    }
}
