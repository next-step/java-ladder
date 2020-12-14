package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {

    private static final String SPLIT_LETTER = ",";

    private final List<String> results;

    public LadderResult(String gameResults) {
        this.results = split(gameResults);
    }

    private List<String> split(String gameResults) {
        String[] dividedName = gameResults.split(SPLIT_LETTER);
        List<String> results =
                Arrays.stream(dividedName)
                        .distinct()
//                        .map(this::valid)
                        .collect(Collectors.toList());

//        if (participants.size() != dividedName.length) {
//            throw new IllegalArgumentException(NAMES_CANNOT_BE_DUPLICATED);
//        }

        return results;
    }

//    private String valid(String name) {
//        if (name.isEmpty() | name.trim().isEmpty()) {
//            throw new IllegalArgumentException(NAME_CAN_NOT_BE_BLANK);
//        }
//
//        if (name.length() > MAX_NAME_LENGTH) {
//            throw new IllegalArgumentException(NAME_IS_TOO_LONG);
//        }
//        return name;
//    }

    boolean containsAll(List<String> results) {
        return this.results.containsAll(results);
    }
}
