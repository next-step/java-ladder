package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Participants {
    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        validateParticipants(participants);

        this.participants = participants;
    }

    public static Participants fromCommaSeparatedNames(String names) {
        List<Participant> participants = Stream.of(names.split(","))
                .map(String::trim)
                .map(Participant::new)
                .collect(Collectors.toList());

        return new Participants(participants);
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public int size() {
        return participants.size();
    }

    private void validateParticipants(List<Participant> participants) {
        if (participants.isEmpty()) {
            throw new IllegalArgumentException("참가자가 없습니다.");
        }
    }

}
