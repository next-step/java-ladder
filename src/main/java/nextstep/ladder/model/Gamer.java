package nextstep.ladder.model;

public class Gamer {
    private final String name;
    private final int MAX_NAME_LENGTH = 5;

    public Gamer(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름은 빈 문자열이 될 수 없습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
