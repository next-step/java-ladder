package nextstep.ladder.domain.player;

import nextstep.ladder.dto.NameDto;

import java.util.Objects;

public class Name {

    private static final int NAME_MAXIMUM_LENGTH = 5;
    private static final String FORBIDDEN_NAME = "all";

    private final String nameStr;

    Name(String nameStr) {
        validate(nameStr);
        this.nameStr = nameStr;
    }

    private void validate(String name) {
        validateLength(name);
        validateName(name);
    }

    private void validateLength(String name) {
        if (name == null || name.length() > NAME_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("이름은 다섯 글자까지 허용됩니다.");
        }
    }

    private void validateName(String name) {
        if (name.equals(FORBIDDEN_NAME)) {
            throw new IllegalArgumentException("all 은 이름으로 사용할 수 없습니다.");
        }
    }

    public NameDto export() {
        return new NameDto(nameStr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name1 = (Name) o;
        return Objects.equals(nameStr, name1.nameStr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameStr);
    }

}
