package ladder;

import java.util.Arrays;
import java.util.List;

public class LadderGame {
    private static final String NAMES_DELIMITER = ",";
    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 1;

    private List<String> names;

    public LadderGame(String input) {
        this.names = settingNames(input);
    }


    private List<String> settingNames(String input) {
        List<String> names = Arrays.asList(input.split(NAMES_DELIMITER));
        validateNames(names);

        return names;
    }

    private void validateNames(List<String> names) {
        names.stream()
                .filter(n -> n.length() > NAME_MAX_LENGTH || n.length() < NAME_MIN_LENGTH)
                .findFirst()
                .ifPresent(n -> {
                    throw new IllegalArgumentException("이름이 길거나 짧습니다.");
                });
    }
}
