package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private final List<Name> participants;

    public Participants(List<Name> participants) {
        this.participants = participants;
    }

    public static Participants from(List<String> names) {
        List<Name> participants = names.stream()
                .map(name -> new Name(name.strip()))
                .collect(Collectors.toList());

        return new Participants(participants);
    }

    public int countOfParticipants() {
        return participants.size();
    }

    public List<Name> getParticipants() {
        return participants;
    }
}
