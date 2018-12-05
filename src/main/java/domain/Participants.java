package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private static final String SEPARATOR = ",";

    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants from(String names) {
        return new Participants(Arrays.stream(names.split(SEPARATOR))
            .map(Participant::new)
            .collect(Collectors.toList()));
    }

    public int size() {
        return participants.size();
    }

    Participant get(int i) {
        return participants.get(i);
    }

    @Override
    public String toString() {
        return participants.stream()
            .map(Participant::toString)
            .collect(Collectors.joining());
    }
}
