package ladder.factory;

import java.util.Arrays;
import java.util.List;

public class LadderResultFactory {
    private static final String SPILT_COMMA_AND_TRIM = "\\s*,\\s*";

    public static List<String> splitPrizes(String prizeNames) {
        if (prizeNames == null || prizeNames.isBlank()) {
            throw new IllegalArgumentException("상품은 빈 값을 입력 할 수 없습니다.");
        }

        String[] splitNames = prizeNames.split(SPILT_COMMA_AND_TRIM);
        return Arrays.asList(splitNames);
    }
}
