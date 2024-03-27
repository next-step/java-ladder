package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private final List<Participant> participants;

    public static Participants of(List<String> names) {
        List<Participant> participants = names.stream()
                .map(Participant::new)
                .collect(Collectors.toUnmodifiableList());
        return new Participants(participants);
    }

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public int getSize() {
        return this.participants.size();
    }
}
