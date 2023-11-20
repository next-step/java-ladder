package ladder.util;

import java.util.List;

public class SplitString {

    private static final String DEFAULT_SPLIT_REGEX = ",";

    private SplitString() {
    }

    public static List<String> splitString(String inputStrings) {
        validate(inputStrings);
        return List.of(inputStrings.split(DEFAULT_SPLIT_REGEX));
    }

    private static void validate(String inputStrings) {
        if (inputStrings == null || inputStrings.isBlank()) {
            throw new IllegalArgumentException("최소 한 글자 이상을 입력해야 합니다.");
        }
    }
}
