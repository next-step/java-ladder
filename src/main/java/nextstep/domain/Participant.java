package nextstep.domain;

import java.util.Objects;

/**
 * 이름 클래스
 */
public class Participant {
    private static final Integer MAX_NAME_LENGTH = 5;
    private final String name;
    private final Integer position;

    public Participant(String name, int Position) {
        validate(name);
        this.name = name;
        this.position = Position;
    }

    private void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 빈 문자열이 될 수 없습니다.");
        }
        if (input.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 " + MAX_NAME_LENGTH + "자까지 허용됩니다.");
        }
        if (input.equals("all")) {
            throw new IllegalArgumentException("사용할 수 없는 이름입니다.");
        }
    }

    public int getPosition() {
        return position;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Participant participant1 = (Participant)o;
        return Objects.equals(name, participant1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
