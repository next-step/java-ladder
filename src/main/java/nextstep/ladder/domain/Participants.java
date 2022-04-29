package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants createParticipants(List<String> names) {
        List<Participant> participants = names.stream()
                .map(Participant::new)
                .collect(Collectors.toList());
        return new Participants(participants);
    }

    public int size() {
        return participants.size();
    }

    public List<Participant> getParticipants() {
        return new ArrayList<>(participants);
    }
}
