package laddergame.dto;

import java.util.List;
import java.util.Objects;

public class LadderGameRunRequest {

    private final List<String> participantNames;
    private final List<String> rewards;
    private final int height;

    public LadderGameRunRequest(List<String> participantNames, List<String> rewards, int height) {
        this.participantNames = participantNames;
        this.rewards = rewards;
        this.height = height;
    }

    public List<String> getParticipantNames() {
        return participantNames;
    }

    public List<String> getRewards() {
        return rewards;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderGameRunRequest that = (LadderGameRunRequest) o;
        return height == that.height && Objects.equals(participantNames, that.participantNames) && Objects.equals(rewards, that.rewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantNames, rewards, height);
    }

    @Override
    public String toString() {
        return "LadderGameRequest{" +
                "participantNames=" + participantNames +
                ", rewards=" + rewards +
                ", height=" + height +
                '}';
    }

}
