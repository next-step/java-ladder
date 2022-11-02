package nextstep.domain;

public class Player {
    private static final int MINIMUM_NAME_LENGTH = 5;
    public final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최소 5자 이하로 짧게 쓰여져야 한다.");
        }
    }

    public String getName() {
        return name;
    }
}
