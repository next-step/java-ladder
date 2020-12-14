package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameInformation {

    public static final String NAMES_CANNOT_BE_DUPLICATED = "Names cannot be duplicated.";
    public static final String INPUT_CAN_NOT_BE_BLANK = "Input can not be blank.";
    public static final String NAME_IS_TOO_LONG = "Name is too long.";
    private static final String SPLIT_LETTER = ",";
    private static final int MAX_NAME_LENGTH = 5;

    private final List<String> participants;
    private final List<String> results;


    public LadderGameInformation(String participants, String results) {
        this.participants = split(participants);
        this.results = split(results);

        validParticipants(this.participants);
    }

    private List<String> split(String letters) {
        String[] dividedLetter = letters.split(SPLIT_LETTER);
        return Arrays.stream(dividedLetter)
                .map(this::valid)
                .collect(Collectors.toList());
    }


    private void validParticipants(List<String> participants) {

        long count = participants.stream()
                .distinct()
                .map(this::validNameLength)
                .count();

        if (participants.size() != count) {
            throw new IllegalArgumentException(NAMES_CANNOT_BE_DUPLICATED);
        }

    }

    private String validNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_IS_TOO_LONG);
        }
        return name;
    }


    private String valid(String name) {
        if (name.isEmpty() || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_CAN_NOT_BE_BLANK);
        }
        return name;
    }

    public int participantsCount() {
        return participants.size();
    }

    public List<String> getParticipants() {
        return participants;
    }

    public List<String> getResults() {
        return results;
    }
}
