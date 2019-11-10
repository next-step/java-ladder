package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private final List<Participant> participants;

    public Participants(List<String> names) {
        this.participants = createParticipants(names);
    }

    private List<Participant> createParticipants(List<String> names) {
        return names
                .stream()
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public List<Participant> getVaule() {
        return new ArrayList<>(participants);
    }

    public int size() {
        return participants.size();
    }
}
