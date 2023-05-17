package ladder.domain;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    protected static final String PARTICIPANT_SEPARATOR = ",";

    private static final String NO_PARTICIPANT_MSG = "1명이상의 참가인원이 있어야합니다.";

    private static final int MIN_PARTICIPANT_NUMBER = 1;

    private final List<Participant> participants;

    public Participants(String participantChunk) {
        this(of(participantChunk));
    }

    public Participants(List<Participant> participants) {
        if(noParticipant(participants)) {
            throw new IllegalArgumentException(NO_PARTICIPANT_MSG);
        }
        this.participants = new ArrayList<>(participants);
    }

    private boolean noParticipant(List<Participant> participants) {
        return participants.size() < MIN_PARTICIPANT_NUMBER;
    }

    private static List<Participant> of(String participantChunk) {
        return Arrays.stream(participantChunk.split(PARTICIPANT_SEPARATOR))
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public List<Participant> immutableGet() {
        return unmodifiableList(this.participants);
    }

    public int countOfPerson() {
        return this.participants.size();
    }

    @Override
    public String toString() {
        return "Participants{" +
                "participants=" + participants +
                '}';
    }
}
