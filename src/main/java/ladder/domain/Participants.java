package ladder.domain;

import ladder.exception.InvalidNameOfParticipantException;
import ladder.exception.InvalidNumberOfParticipantsException;
import ladder.exception.NotFoundParticipantException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Participants {
    private static final String SEPARATOR_OF_NAMES = ",";

    private final String[] names;

    public Participants(final String names) {
        String[] namesOfParticipants = names.split(SEPARATOR_OF_NAMES);
        validateNumberOfParticipants(namesOfParticipants);
        validateNameOfParticipants(namesOfParticipants);
        this.names = namesOfParticipants;
    }

    void validateNumberOfParticipants(String[] names) {
        if (names.length == 0 || names.length == 1) {
            throw new InvalidNumberOfParticipantsException();
        }
    }

    void validateNameOfParticipants(String[] names) {
        for (String name : names) {
            validateNameOfParticipants(name);
        }
    }

    private void validateNameOfParticipants(String name) {
        if (name.length() == 0 || name.length() > 5) {
            throw new InvalidNameOfParticipantException(name);
        }
    }

    public int getNumberOfParticipants() {
        return names.length;
    }

    public List<String> getNamesOfParticipants() {
        return Collections.unmodifiableList(Arrays.asList(names));
    }

    public int contains(String name) {
        if ("all".equals(name)) {
            return -1;
        }

        return IntStream.range(0, names.length)
                .filter(i -> name.equals(names[i]))
                .findFirst()
                .orElseThrow(NotFoundParticipantException::new);
    }

    public String getParticipant(int index) {
        return names[index];
    }
}
