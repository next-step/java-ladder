package ladder.domain;

public class User {
    private final int NAME_MAX_LENGTH = 5;

    private final String name;

    public User(String name) {
        validName(name);
        this.name = name;
    }

    private void validName(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 가능합니다");
        }
    }

    public String getName() {
        return name;
    }
}
