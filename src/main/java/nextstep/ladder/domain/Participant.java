package nextstep.ladder.domain;

import java.util.Objects;

public class Participant {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Participant(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new RuntimeException("이름은 비어있을 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new RuntimeException("이름은 최대 " + MAX_NAME_LENGTH + "글자까지 가능합니다.");
        }
    }

    public boolean hasName(String name) {
        return Objects.equals(this.name, name);
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
        return Objects.hashCode(name);
    }
}
