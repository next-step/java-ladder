package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private static final String SEPARATOR = ",";

    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants fromInput(String input) {
        return new Participants(
            Arrays.stream(input.split(SEPARATOR))
                .map(Participant::new)
                .collect(Collectors.toList()));
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public int countOfParticipants() {
        return participants.size();
    }

    public int indexOf(Participant participant) {
        return participants.indexOf(participant);
    }

    public boolean contains(Participant participant) {
        return participants.contains(participant);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        participants.forEach(participant -> stringBuilder.append(participant.toString()));

        return stringBuilder.toString();
    }
}
