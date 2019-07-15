package ladder.model;

import java.util.Objects;

public class Participant {
    public static final int MAX_LENGTH = 5;
    public static final String MESSAGE_OF_OUT_NAME_LENGTH = "참가자의 이름은 %d 글자를 넘을 수 없습니다.";

    private final String name;

    public Participant(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(MESSAGE_OF_OUT_NAME_LENGTH, MAX_LENGTH));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Participant)) { return false; }
        final Participant that = (Participant) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
