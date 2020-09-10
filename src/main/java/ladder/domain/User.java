package ladder.domain;

public class User {
    private final String name;
    private static int NAME_MAX_LENGTH = 5;

    public User(String name) {
        validateEmpty(name);
        validateUserName(name);
        this.name = name;
    }

    public String getUserName() {
        return name;
    }

    private void validateEmpty(String userName) {
        if(userName == null || userName.trim().isEmpty()) {
            throw new IllegalArgumentException("이름을 입력해 주십시오.");
        }
    }

    private void validateUserName(String userName) {
        if(userName.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자 입니다.");
        }
    }

}
