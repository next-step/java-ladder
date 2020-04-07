package ladder.domain;

import java.util.Objects;

public class Participant {
    private final String name;
    private static final int NAME_LEN_LIMIT = 5;

    private Participant(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 5자 이하이어야 합니다.");
        }

        name = name.trim();
        if (name.isEmpty() || name.length() > NAME_LEN_LIMIT) {
            throw new IllegalArgumentException("이름은 5자 이하이어야 합니다.");
        }

        this.name = name;
    }

    public static Participant name(String name) {
        return new Participant(name);
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
