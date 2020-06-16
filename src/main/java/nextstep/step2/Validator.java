package nextstep.step2;

import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    private final int MAX_USER_NAME_LENGH = 5;

    public int checkLadderHeight(int ladderHeight) {
        try {
            if(ladderHeight > 0) {
                return ladderHeight;
            }
            throw new Exception("사다리의 높이는 1 이상이어야 합니다.");
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public List<String> userNameLengthIsUnderFive(List<String> userNames) {
        return userNames.stream().map(this::checkUserName).collect(Collectors.toList());
    }

    private String checkUserName(String userName) {
        try {
            if (userName.length() <= MAX_USER_NAME_LENGH) {
                return userName;
            }
            throw new IllegalArgumentException("참여할 사람의 이름은 최대 5자 입니다.");
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
