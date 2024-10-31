package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public Participants(String participantsName) {
        this(Arrays.stream(participantsName.split(","))
                .map(String::trim)
                .map(Participant::new)
                .collect(Collectors.toList()));
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public int size() {
        return participants.size();
    }
}
