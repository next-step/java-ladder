package nextstep.ladder.view;

import nextstep.ladder.constant.LadderConstants;

import java.util.Arrays;
import java.util.List;

public class LadderGameViewHelper {

    public static List<String> parseUserNameInput(String userNameInput) {
        validateUserNameInput(userNameInput);
        String[] userNames = userNameInput.split(LadderConstants.USER_NAME_SEPARATOR);
        return Arrays.asList(userNames);
    }

    private static void validateUserNameInput(String userNameInput) {
        if (userNameInput == null || userNameInput.length() == 0) {
            throw new IllegalArgumentException(LadderConstants.INVALID_NULL_USER_NAME_EXCEPTION_MESSAGE);
        }
    }
}
