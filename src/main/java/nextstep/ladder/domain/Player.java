package nextstep.ladder.domain;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_INDEX = 0;

    private final int index;
    private final String name;

    public Player(int index, String name) {
        validate(index);
        validate(name);
        this.index = index;
        this.name = name;
    }

    private static void validate(int index) {
        if (index < MIN_INDEX) {
            throw new IllegalArgumentException("인덱스는 " + MIN_INDEX + "보다 작을 수 없습니다.");
        }
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

    public boolean sameIndex(int index) {
        return this.index == index;
    }
}
