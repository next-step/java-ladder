package ladder.domain.participant;

import ladder.exception.ParticipantListNullPointerException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Participants {

    private final List<Participant> participants;

    public static final Participants of(final String[] names) {
        return of(mapToParticipantList(names));
    }

    private static final List<Participant> mapToParticipantList(final String[] names) {
        return Arrays.stream(names)
                .map(Participant::of)
                .collect(Collectors.toList());
    }

    public static final Participants of(final List<Participant> participants) {
        return new Participants(participants);
    }

    private Participants(final List<Participant> participants) {
        validateNull(participants);
        this.participants = participants;
    }

    private final void validateNull(final List<Participant> participants) {
        if (Objects.isNull(participants)) {
            throw new ParticipantListNullPointerException();
        }
    }

    public final int countOfParticipants() {
        return participants.size();
    }

    public final List<String> values() {
        return participants.stream()
                .map(Participant::name)
                .collect(Collectors.toList());
    }
}
