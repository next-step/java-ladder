package ladder;

public class Player {

    private final String name;

    public Player(final String name) {
        validateNameIsNotNullOrBlank(name);

        this.name = name;
    }

    private void validateNameIsNotNullOrBlank(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("플레이어의 이름은 null이거나 비어있을 수 없습니다. 이름: " + name);
        }
    }
}
