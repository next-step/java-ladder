package nextstep.domain;

public class User {
    private static final int MAX_LENGTH = 5;
    private final String userName;

    public User(String userName) {
        validate(userName);
        this.userName = userName;
    }

    private void validate(String userName) {
        if (userName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자 까지만 허용합니다.");
        }
    }

    public String getUserName() {
        return userName;
    }
}
