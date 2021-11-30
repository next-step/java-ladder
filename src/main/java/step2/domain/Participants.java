package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    public static final String COMMA = ",";

    private final List<Participant> participants = new ArrayList<>();

    private Participants() {
    }

    private Participants(String[] names) {
        for (String name : names) {
            participants.add(Participant.of(name));
        }
    }

    public static Participants of(String names) {
        return new Participants(splitNames(names));
    }

    public List<String> getNames() {
        return participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }

    public int getSize() {
        return participants.size();
    }

    private static String[] splitNames(String names) {
        return names.split(COMMA);
    }
}
