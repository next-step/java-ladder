package ladder.domain;

public class User {
    private final String name;
    private final int position;
    private static int NAME_MAX_LENGTH = 5;

    public User(String name, int position) {
        validateEmpty(name);
        validateUserName(name);
        this.name = name;
        this.position = position;
    }

    public String getUserName() {
        return name;
    }

    public int getPosition() {
        return position;
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
