package nextstep.ladder.domain.participant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    public static final String PARTICIPANTS_LIMIT_MESSAGE = "참가자는 2명 이상이어야 합니다.";
    public static final String DELIMITER = ",";
    private final List<Participant> values;

    private Participants(List<Participant> inputs) {
        this.values = inputs;
    }

    public static Participants from(String input) {
        String[] splitInputs = input.split(DELIMITER);

        if (splitInputs.length < 2) {
            throw new IllegalArgumentException(PARTICIPANTS_LIMIT_MESSAGE);
        }

        List<Participant> participants = Arrays.stream(splitInputs)
                .map(Participant::from)
                .collect(Collectors.toList());

        return new Participants(participants);
    }

    public List<Participant> values() {
        return values;
    }
}
