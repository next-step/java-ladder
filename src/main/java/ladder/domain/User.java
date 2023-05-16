package ladder.domain;

public class User {
    private static final String EXCEPTION_MESSAGE_NAMELENGTH = "이름은 최대 5글자까지 입력 가능합니다.";
    private static final int NAME_LENGTH = 5;
    private final String name;

    public User(String name) {
        validateUserName(name);
        this.name = name;
    }

    private static void validateUserName(String name) {
        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_NAMELENGTH + name);
        }
    }

    public String name() {
        return this.name;
    }

}
