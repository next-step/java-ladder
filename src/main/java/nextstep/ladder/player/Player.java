package nextstep.ladder.player;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String BLANK = " ";

    public String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateEmpty(name);
        validateLength(name);
    }

    private static void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하이어야 합니다.");
        }
    }

    private static void validateEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 null 또는 빈 문자열일 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public String toStringWithBlank() {
        return name + BLANK.repeat(MAX_NAME_LENGTH + 1 - name.length());
    }
}
