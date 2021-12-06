package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private static final String INPUT_STRING_REGEX = ",";
    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants create(String input) {
        return new Participants(
            Arrays.stream(input.split(INPUT_STRING_REGEX))
                .map(Participant::new)
                .collect(Collectors.toList()));
    }

    public int size() {
        return participants.size();
    }

    public List<Participant> getParticipants() {
        return participants;
    }
}
