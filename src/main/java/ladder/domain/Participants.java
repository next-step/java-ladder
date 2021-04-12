package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Participants {

    public static final String REGEX = ",";

    private final List<Participant> Participants;

    private Participants(List<Participant> participants) {
        Participants = participants;
    }

    public static final Participants of(String names) {
        return of(stringToParticipantList(names));
    }

    public static final Participants of(List<Participant> participants) {
        return new Participants(participants);
    }

    private static final List<Participant> stringToParticipantList(String names) {
        return Arrays.stream(names.split(REGEX))
                .map(Participant::of)
                .collect(Collectors.toList());
    }
}
