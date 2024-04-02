package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Participants {

    private static final String ALL_PARTICIPANTS = "all";

    private final List<Participant> participants;

    public static Participants of(List<String> names) {
        List<Participant> participants = names.stream()
                .map(Participant::of)
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

    public int startPosition(Participant executeParticipant) {
        return participants.indexOf(executeParticipant);
    }

    public Stream<Participant> stream() {
        return this.participants.stream();
    }

    public static boolean meanAllParticipants(String name) {
        return ALL_PARTICIPANTS.equals(name);
    }

}
