package ladder.domain;

import java.util.Objects;

public class LadderMember {
    private static final int NAME_MAX_LENGTH = 5;
    private static final String NAME_LENGTH_MESSAGE = "이름은 5자 이하로 입력해야 합니다.";

    private final String name;

    public LadderMember(String name) {
        this.name = validate(name);
    }

    private static String validate(String name) {
        checkNull(name);
        checkLength(name);
        return name;
    }

    private static void checkLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_MESSAGE);
        }
    }

    private static void checkNull(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(NAME_LENGTH_MESSAGE);
        }
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderMember that = (LadderMember) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
