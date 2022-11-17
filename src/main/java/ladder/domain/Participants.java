package ladder.domain;

import java.util.List;

public class Participants {
    private static final int MIN_PARTICIPANTS = 2;

    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        if(MIN_PARTICIPANTS > participants.size()){
            throw new IllegalArgumentException("참가자는 2명이상부터 가능합니다.");
        }
        this.participants = participants;
    }

    public int countOfMember(){
        return participants.size();
    }

    public List<Participant> getParticipants() {
        return participants;
    }
}
