package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameInformation {

    public static final String NAMES_CANNOT_BE_DUPLICATED = "Names cannot be duplicated.";
    public static final String SIZE_CANNOT_BE_DIFFERENT = "Names cannot be duplicated.";
    public static final String INPUT_CAN_NOT_BE_BLANK = "Input can not be blank.";
    public static final String NAME_IS_TOO_LONG = "Name is too long.";
    private static final String SPLIT_LETTER = ",";
    private static final int MAX_NAME_LENGTH = 5;

    private final List<String> participants;
    private final List<String> results;


    public LadderGameInformation(String participants, String results) {
        this.participants = split(participants);
        this.results = split(results);
        valid();
    }

    private List<String> split(String letters) {
        String[] dividedLetter = letters.split(SPLIT_LETTER);
        return Arrays.stream(dividedLetter)
                .map(this::validName)
                .collect(Collectors.toList());
    }


    private void valid() {

        if (this.participants.size() != this.results.size()) {
            throw new IllegalArgumentException(SIZE_CANNOT_BE_DIFFERENT);
        }

        long count = this.participants.stream()
                .distinct()
                .map(this::validNameLength)
                .count();

        if (this.participants.size() != count) {
            throw new IllegalArgumentException(NAMES_CANNOT_BE_DUPLICATED);
        }

    }

    private String validNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_IS_TOO_LONG);
        }
        return name;
    }


    private String validName(String name) {
        if (name.isEmpty() || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_CAN_NOT_BE_BLANK);
        }
        return name;
    }

    public int getParticipantsCount() {
        return participants.size();
    }

    public List<String> getParticipants() {
        return participants;
    }

    public List<String> getResults() {
        return results;
    }
}
