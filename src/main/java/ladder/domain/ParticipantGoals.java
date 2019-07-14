package ladder.domain;

import java.util.Collections;
import java.util.List;

public class ParticipantGoals {

    private final List<ParticipantGoal> participantGoals;

    public ParticipantGoals(List<ParticipantGoal> participantGoals) {
        this.participantGoals = participantGoals;
    }

    public ParticipantGoal find(String name) {

        return participantGoals.stream()
                .filter(participantGoal -> participantGoal.getParticipant().getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("참여자명이 존재하지 않습니다."));
    }

    public List<ParticipantGoal> findAll() {
        return Collections.unmodifiableList(participantGoals);
    }
}
