package nextstep.ladder.player;

import nextstep.ladder.Direction;
import nextstep.ladder.Position;

import java.util.Objects;

public class Entry {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String BLANK = " ";

    private String name;
    private Position position;

    public Entry(String name, Position position) {
        validate(name);
        this.name = name;
        this.position = position;
    }

    private void validate(String name) {
        validateEmpty(name);
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하이어야 합니다.");
        }
    }

    private void validateEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 null 또는 빈 문자열일 수 없습니다.");
        }
    }

    public void move(Direction direction) {
        this.position.move(direction);
    }

    @Override
    public String toString() {
        return name;
    }

    public String toStringWithBlank() {
        return name + BLANK.repeat(MAX_NAME_LENGTH + 1 - name.length());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;

        Entry entry = (Entry) o;

        if (!position.equals(entry.position)) return false;
        return Objects.equals(name, entry.name);
    }
}
