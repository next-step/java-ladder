package nextstep.ladder.domain.game;

import nextstep.ladder.domain.game.exception.IllegalMaxLengthValueException;

import java.util.Objects;

public class Participant {
    public static final int MAX_NAME_LENGTH = 5;
    private static final String MAX_NAME_LENGTH_ERROR_MESSAGE =
            "이름은 %d글자를 넘을 수 없습니다.";
    private String name;

    public Participant(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalMaxLengthValueException(
                    String.format(MAX_NAME_LENGTH_ERROR_MESSAGE,
                            MAX_NAME_LENGTH));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
