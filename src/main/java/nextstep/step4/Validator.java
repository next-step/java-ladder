package nextstep.step4;

import nextstep.step4.domain.User;
import nextstep.step4.resource.LadderStringResource;
import nextstep.step4.utils.LadderUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Validator {
    private final int MAX_USER_NAME_LENGH = 5;

    public int checkLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException(LadderStringResource.LADDER_HEIGHT_EXCEPTION_TEXT);
        }
        return ladderHeight;
    }

    public List<String> checkUserNameLength(List<String> userNames) {
        return userNames.stream().map(this::checkUserName).collect(Collectors.toList());
    }

    private String checkUserName(String userName) {
        if (userName.length() > MAX_USER_NAME_LENGH) {
            throw new IllegalArgumentException(LadderStringResource.USER_NAME_EXCEPTION_TEXT);
        }
        return userName;
    }

    public List<String> checkPlayResult(List<String> userNames, List<String> playResult) {
        if (userNames.size() != playResult.size()) {
            throw new IllegalArgumentException(LadderStringResource.PLAY_RESULT_LENGTH_EXCEPTION);
        }
        checkResultBlank(playResult);

        return playResult;
    }

    private void checkResultBlank(List<String> playResult) {
        for (String s : playResult) {
            if (LadderUtils.isBlank(s)) {
                throw new IllegalArgumentException(LadderStringResource.PLAY_RESULT_BLANK_EXCEPTION);
            }
        }
    }

    public String checkUserNameForResult(String userName, Map<String, User> resultMap) {
        if (!resultMap.containsKey(userName) && !userName.equals("all")) {
            throw new IllegalArgumentException(LadderStringResource.USER_NAME_FOR_RESULT_EXCEPTION);
        }
        return userName;
    }
}
