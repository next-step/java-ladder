package ladder;

import java.util.Arrays;
import java.util.List;

public class LadderGame {
    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 1;

    private List<String> names;

    public LadderGame(String... input) {
        validateNames(input);
        this.names = Arrays.asList(input);
    }

    private void validateNames(String[] names) {
        Arrays.stream(names)
                .filter(n -> n.length() > NAME_MAX_LENGTH || n.length() < NAME_MIN_LENGTH)
                .findFirst()
                .ifPresent(n -> {
                    throw new IllegalArgumentException("이름이 길거나 짧습니다.");
                });
    }
}
