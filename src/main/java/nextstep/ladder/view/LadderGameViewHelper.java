package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;

public class LadderGameViewHelper {

    private static final String INVALID_USER_NAME_EXCEPTION_MESSAGE = "사다리 게임에 참여할 사람을 입력해주세요.";
    private static final String USER_NAME_SEPARATOR = ",";

    public static List<String> parseUserNameInput(String userNameInput) {
        validateUserNameInput(userNameInput);
        String[] userNames = userNameInput.split(USER_NAME_SEPARATOR);
        return Arrays.asList(userNames);
    }

    private static void validateUserNameInput(String userNameInput) {
        if (userNameInput == null || userNameInput.length() == 0) {
            throw new IllegalArgumentException(INVALID_USER_NAME_EXCEPTION_MESSAGE);
        }
    }
}
