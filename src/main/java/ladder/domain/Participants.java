package ladder.domain;

import ladder.exception.ParticipantListNullPointerException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Participants {

    public static final String REGEX = ",";

    private final List<Participant> Participants;

    private Participants(List<Participant> participants) {
        validateNull(participants);
        Participants = participants;
    }

    private final void validateNull(List<Participant> participants) {
        if (Objects.isNull(participants)) {
            throw new ParticipantListNullPointerException();
        }
    }

    public static final Participants of(List<Participant> participants) {
        return new Participants(participants);
    }

    public static final Participants of(String names) {
        return of(stringToParticipantList(names));
    }

    private static final List<Participant> stringToParticipantList(String names) {
        return Arrays.stream(names.split(REGEX))
                .map(Participant::of)
                .collect(Collectors.toList());
    }
}
