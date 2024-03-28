package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private final List<Participant> participants;

    public static Participants of(List<String> names, int nameMaxLength) {
        List<Participant> participants = names.stream()
                .map((name) -> new Participant(name, nameMaxLength))
                .collect(Collectors.toUnmodifiableList());
        return new Participants(participants);
    }

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public int numberOf() {
        return this.participants.size();
    }

    public List<Participant> get() {
        return this.participants;
    }
}
