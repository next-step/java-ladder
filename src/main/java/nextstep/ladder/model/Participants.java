package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public final class Participants {
    private static final String PARTICIPANT_COUNT_EXCEPTION_MESSAGE = "참가자의 수는 최소 2명이여야 합니다.";
    private static final int LEAST_PARTICIPANT_COUNT = 2;

    private final List<Participant> participants;

    public Participants(List<String> participantNames) {
        validate(participantNames.size());
        this.participants = join(participantNames);
    }

    public static int create(List<String> participantsNames) {
        return new Participants(participantsNames).size();
    }

    private List<Participant> join(List<String> participantNames) {
        return participantNames
                .stream()
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    private int size() {
        return participants.size();
    }

    private void validate(int size) {
        if (size < LEAST_PARTICIPANT_COUNT) {
            throw new IllegalArgumentException(PARTICIPANT_COUNT_EXCEPTION_MESSAGE);
        }
    }


}
