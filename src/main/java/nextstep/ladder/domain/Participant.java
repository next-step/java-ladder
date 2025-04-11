package nextstep.ladder.domain;

import java.util.Objects;

public class Participant {
    public static final String NULL_OR_EMPTY_ERROR_MESSAGE = "이름은 null 이거나 빈 문자열일 수 없습니다";
    public static final String TOO_LENGTH_ERROR_MESSAGE = "이름은 1자 이상 5자 이하로 입력해야 합니다";

    private final String name;
    private int position;

    public Participant(String name) {
        this(name, 0);
    }

    public Participant(String name, int position) {
        this.valid(name);
        this.name = name.trim();
        this.position = position;
    }

    private void valid(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_ERROR_MESSAGE);
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException(TOO_LENGTH_ERROR_MESSAGE + " - " + name);
        }
    }

    public int position() {
        return position;
    }

    public void move(LadderLine line) {
        this.position = line.getNextPosition(position);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return position == that.position && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
