package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private static final String DELIMITER = ",";

    private final List<Participant> participants;

    public Participants(String inputParticipants) {
        this.participants = createParticipants(parseInputParticipants(inputParticipants));
    }

    private List<String> parseInputParticipants(String inputParticipants) {
        return List.of(inputParticipants.split(DELIMITER));
    }

    private List<Participant> createParticipants(List<String> inputParticipants) {
        return inputParticipants.stream()
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public Integer getNumbersOfParticipants() {
        return participants.size();
    }
}
