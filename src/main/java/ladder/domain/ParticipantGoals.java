package ladder.domain;

import java.util.Map;

public class ParticipantGoals {

    private final Map<Participant, Goal> participantGoals;

    public ParticipantGoals(Map<Participant, Goal> participantGoals) {

        this.participantGoals = participantGoals;
    }

    public Goal findGoal(String name) {

        return participantGoals.entrySet()
                .stream()
                .filter(participantGoalEntry -> name.equals(participantGoalEntry.getKey().getName()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("참여자명이 존재하지 않습니다."));
    }
}
