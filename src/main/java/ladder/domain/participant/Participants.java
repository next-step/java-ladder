package ladder.domain.participant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Participants {

    private final List<Participant> participants;

    public static final Participants of(String[] names) {
        return of(mapToParticipantList(names));
    }

    private static final List<Participant> mapToParticipantList(String[] names) {
        return Arrays.stream(names)
                .map(Participant::of)
                .collect(Collectors.toList());
    }

    public static final Participants of(List<Participant> participants) {
        return new Participants(participants);
    }

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }


}
