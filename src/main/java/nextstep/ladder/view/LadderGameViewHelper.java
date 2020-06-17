package nextstep.ladder.view;

import nextstep.ladder.constant.LadderConstants;

import java.util.Arrays;
import java.util.List;

public class LadderGameViewHelper {

    public static List<String> parseUserNameInput(String userNameInput) {
        validateUserNameInput(userNameInput);
        return Arrays.asList(userNameInput.split(LadderConstants.USER_NAME_SEPARATOR));
    }

    private static void validateUserNameInput(String userNameInput) {
        if (userNameInput == null || userNameInput.length() == 0) {
            throw new IllegalArgumentException(LadderConstants.INVALID_NULL_USER_NAME_EXCEPTION_MESSAGE);
        }
    }
}
