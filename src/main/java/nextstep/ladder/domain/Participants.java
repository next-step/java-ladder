package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants of(String participants) {
        return new Participants(Arrays.asList(participants.split(",")).stream()
                .map(participant -> Participant.of(participant))
                .collect(Collectors.toList()));
    }

    public int getParticipantsSize() {
        return participants.size();
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

}
