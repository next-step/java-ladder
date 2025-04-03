package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants from(List<String> participantNames) {
        List<Participant> participants = participantNames.stream()
                .map(Participant::new)
                .collect(Collectors.toList());
        return new Participants(participants);
    }
}