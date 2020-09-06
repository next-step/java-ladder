package nextstep.ladder.utils;

import static nextstep.ladder.utils.CommonConstant.NUMBER_FIVE;
import static nextstep.ladder.utils.CommonConstant.NUMBER_TWO;

public class LadderValidation {

    private static final String INVALID_INPUT_NAME_LENGTH = "게임에 참여하는 이름은 최대 5글자 입니다.";
    private static final String INVALID_INPUT_NAME_BLANK = "이름은 공백이 올 수 없습니다.";
    private static final String INVALID_LADDER_COUNT_OF_USER = "사다리게임은 2명 이상부터 진행할 수 있습니다.";
    private static final String INVALID_LADDER_POINT_RULE = "왼쪽과 오른쪽 모두 선이 있을 수 없습니다.";

    private LadderValidation() {}

    public static void validateUserNameLength(String name) {
        if (name.length() > NUMBER_FIVE) {
            throw new RuntimeException(INVALID_INPUT_NAME_LENGTH);
        }
    }

    public static void validateUserNameIsBlank(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_NAME_BLANK);
        }
    }

    public static void validateCountOfUser(int countOfUser) {
        if (countOfUser < NUMBER_TWO) {
            throw new IllegalArgumentException(INVALID_LADDER_COUNT_OF_USER);
        }
    }

    public static void validateLadderPointRule(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(INVALID_LADDER_POINT_RULE);
        }
    }

}
