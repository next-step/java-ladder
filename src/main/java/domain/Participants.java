package domain;

import exception.InvalidParticipantsNumberException;

import java.util.Arrays;
import java.util.List;

import static common.DelimiterConstants.SPLIT_DELIMITER;

public class Participants {
    private static final int MIN_NUMBER_BOUNDARY = 2;

    private final List<String> participants;

    private Participants(final List<String> participants) {
        this.participants = participants;
    }

    public static Participants of(final String commaSeparatedNames) {
        String[] participants = commaSeparatedNames.split(SPLIT_DELIMITER);
        if(participants.length < MIN_NUMBER_BOUNDARY) {
            throw new InvalidParticipantsNumberException();
        }

        return new Participants(Arrays.asList(participants));
    }

    public int size() {
        return participants.size();
    }

    public List<String> getParticipants() {
        return participants;
    }

    public int indexOf(final String name) {
        return participants.indexOf(name);
    }

    public String get(final int index) {
        return participants.get(index);
    }
}
