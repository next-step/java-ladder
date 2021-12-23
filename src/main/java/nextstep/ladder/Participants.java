package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    public static final String DELIMITER = ",";
    private final List<Participant> values;

    private Participants(List<Participant> inputs) {
        this.values = inputs;
    }

    public static Participants from(String input) {
        String[] splitInputs = input.split(DELIMITER);

        List<Participant> participants = Arrays.stream(splitInputs)
                .map(Participant::from)
                .collect(Collectors.toList());

        return new Participants(participants);
    }

    public List<Participant> values() {
        return values;
    }
}
