package ladder.model;

public class PlayerName {
    private final String name;

    PlayerName(String name) {
        validateNotEmpty(name);
        this.name = name;
    }

    private void validateNotEmpty(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("참가자 이름이 비어있습니다.");
        }
    }
}
