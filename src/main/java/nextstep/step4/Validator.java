package nextstep.step4;

import nextstep.step4.domain.User;
import nextstep.step4.resource.LadderStringResource;
import nextstep.step4.utils.LadderUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Validator {
    private static final int MAX_USER_NAME_LENGH = 5;

    public static int checkLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException(LadderStringResource.LADDER_HEIGHT_EXCEPTION_TEXT);
        }
        return ladderHeight;
    }

    public static List<String> checkUserNameLength(List<String> userNames) {
        return userNames.stream().map(Validator::checkUserName).collect(Collectors.toList());
    }

    private static String checkUserName(String userName) {
        if (userName.length() > MAX_USER_NAME_LENGH) {
            throw new IllegalArgumentException(LadderStringResource.USER_NAME_EXCEPTION_TEXT);
        }
        return userName;
    }

    public static List<String> checkPlayResult(List<String> userNames, List<String> playResult) {
        if (userNames.size() != playResult.size()) {
            throw new IllegalArgumentException(LadderStringResource.PLAY_RESULT_LENGTH_EXCEPTION);
        }
        checkResultBlank(playResult);

        return playResult;
    }

    private static void checkResultBlank(List<String> playResult) {
        for (String s : playResult) {
            if (LadderUtils.isBlank(s)) {
                throw new IllegalArgumentException(LadderStringResource.PLAY_RESULT_BLANK_EXCEPTION);
            }
        }
    }

    public static String checkUserNameForResult(String userName, Map<String, User> resultMap) {
        if (!resultMap.containsKey(userName) && !userName.equals("all")) {
            throw new IllegalArgumentException(LadderStringResource.USER_NAME_FOR_RESULT_EXCEPTION);
        }
        return userName;
    }
}
