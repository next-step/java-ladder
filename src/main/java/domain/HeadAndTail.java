package domain;

public class HeadAndTail {
    private final Participants participants;
    private final Rewards rewards;

    private HeadAndTail(final Participants participants, final Rewards rewards) {
        this.participants = participants;
        this.rewards = rewards;
    }

    public static HeadAndTail init(final Participants participants, final Rewards rewards) {
        return new HeadAndTail(participants, rewards);
    }

    public Participants getParticipants() {
        return participants;
    }

    public Rewards getRewards() {
        return rewards;
    }

    public int participantsIndexOf(final String name) {
        return participants.indexOf(name);
    }

    public String getRewardAt(final int index) {
        return rewards.getRewardAt(index);
    }
}
