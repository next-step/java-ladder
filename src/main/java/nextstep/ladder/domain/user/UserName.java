package nextstep.ladder.domain.user;

public class UserName {
    private String userName;

    public UserName(String userNameString) {
        validate(userNameString);
        userName = userNameString;
    }

    private void validate(String userNameString) {
        if (userNameString.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public String getUserName() {
        return userName;
    }
}
