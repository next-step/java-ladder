package ladder.model;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    Player(String name) {
        validate(name);
        this.name = name;
    }

    String getName() {
        return name;
    }

    boolean matchName(String name) {
        validate(name);
        return this.name.equals(name);
    }

    private void validate(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("참가자 이름이 비어있습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("참가자 이름은 %d자를 넘을 수 없습니다.", MAX_NAME_LENGTH));
        }
    }
}
