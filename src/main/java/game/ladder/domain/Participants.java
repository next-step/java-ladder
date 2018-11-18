package game.ladder.domain;

import spark.utils.Assert;

import java.util.SortedSet;

public class Participants {

    private static final int MIN_PARTICIPANTS = 2;

    private final SortedSet<Participant> participants;

    public Participants(SortedSet<Participant> participants) {
        Assert.isTrue(participants.size() >= MIN_PARTICIPANTS, "적어도 두 명 이상의 참여자가 필요합니다.");
        this.participants = participants;
    }

    public int size() {
        return this.participants.size();
    }

    public String getAllFormattedNames() {
        return this.participants.stream().map(Participant::formattedParticipantName).reduce("", String::concat);
    }
}
