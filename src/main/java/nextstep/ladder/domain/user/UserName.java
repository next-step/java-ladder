package nextstep.ladder.domain.user;

public class UserName {
    private final int USER_NAME_MAXIMUM = 5;

    private String userName;

    public UserName(String userNameString) {
        validate(userNameString);
        userName = userNameString;
    }

    private void validate(String userNameString) {
        if (userNameString == null || "".equals(userNameString)) {
            throw new IllegalArgumentException("이름은 null 또는 빈값을 입력할 수 없습니다.");
        }
        if (userNameString.length() > USER_NAME_MAXIMUM) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public String getUserName() {
        return userName;
    }
}
