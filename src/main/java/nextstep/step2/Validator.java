package nextstep.step2;

import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    private final int MAX_USER_NAME_LENGH = 5;

    public int checkLadderHeight(int ladderHeight) {
        if(ladderHeight <= 0) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
        }
        return ladderHeight;
    }

    public List<String> checkUserNameLength(List<String> userNames) {
        return userNames.stream().map(this::checkUserName).collect(Collectors.toList());
    }

    private String checkUserName(String userName) {
        if (userName.length() > MAX_USER_NAME_LENGH) {
            throw new IllegalArgumentException("참여할 사람의 이름은 최대 5자 입니다.");
        }
        return userName;
    }
}
