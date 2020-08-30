package nextstep.ladder.utils;

import static nextstep.ladder.utils.CommonConstant.NUMBER_FIVE;

public class LadderValidation {

    private static final String INVALID_INPUT_NAME_LENGTH = "게임에 참여하는 이름은 최대 5글자 입니다.";
    private static final String INVALID_INPUT_NAME_BLANK = "이름은 공백이 올 수 없습니다.";

    private LadderValidation() {}

    public static void validateLadderNameLength(String name) {
        if (name.length() > NUMBER_FIVE) {
            throw new RuntimeException(INVALID_INPUT_NAME_LENGTH);
        }
    }

    public static void validateLadderNameIsBlank(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_NAME_BLANK);
        }
    }


}
