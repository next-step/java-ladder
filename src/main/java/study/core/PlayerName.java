package study.core;

public class PlayerName {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public PlayerName(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAX_NAME_LENGTH + "자 이하만 가능합니다.");
        }
    }

}
