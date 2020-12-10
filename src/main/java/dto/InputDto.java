package dto;

import domain.Participants;
import domain.Rewards;

public class InputDto {
    private Participants participants;
    private Rewards rewards;
    private int ladderHeight;

    public Participants getParticipants() {
        return participants;
    }

    public Rewards getRewards() {
        return rewards;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public void setParticipants(final Participants participants) {
        this.participants = participants;
    }

    public void setRewards(final Rewards rewards) {
        this.rewards = rewards;
    }

    public void setLadderHeight(final int ladderHeight) {
        this.ladderHeight = ladderHeight;
    }
}
