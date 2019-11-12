package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Participants {
    private static final String COMMA_DELIMITER = ",";

    private List<Person> participants;

    public Participants(String participantsInput) {
        splitByDelimiter(participantsInput);
    }

    private void splitByDelimiter(String participantsInput) {
        participants = new ArrayList<>();

        String[] splitedParticipants = participantsInput.split(COMMA_DELIMITER);

        for (String splitedParticipant : splitedParticipants) {
            participants.add(new Person(splitedParticipant));
        }
    }

    public int countOfParticipants() {
        return participants.size();
    }
}
