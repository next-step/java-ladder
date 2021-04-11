package nextstep.ladder.domain.generator;

import nextstep.ladder.utils.StringUtils;

public class CollectionGenerator {
    private final static String INPUT_SEPARATOR = ",";
    private final static int MIN_INPUT_LENGTH = 2;

    private static void validation(String value) {
        if (StringUtils.isEmpty(value)) {
            throw new IllegalArgumentException("입력값은 비어있는 값 일 수 없습니다.");
        }
        if (value.split(INPUT_SEPARATOR).length < MIN_INPUT_LENGTH) {
            throw new IllegalArgumentException("입력값은 최소 2개 이상이어야 합니다.");
        }
    }

    public static Players players(String value) {
        validation(value);
        return Players.from(value.split(INPUT_SEPARATOR));
    }

    public static Results results(String value) {
        validation(value);
        return Results.from(value.split(INPUT_SEPARATOR));
    }
}
