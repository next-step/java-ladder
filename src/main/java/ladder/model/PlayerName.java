package ladder.model;

public class PlayerName {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    PlayerName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("참가자 이름이 비어있습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("참가자 이름은 %d자를 넘을 수 없습니다.", MAX_NAME_LENGTH));
        }
    }

    String getName() {
        return name;
    }
}
