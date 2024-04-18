package nextstep.ladder.domain;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    
    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
