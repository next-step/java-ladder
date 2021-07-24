package nextstep.ladder.domain;

import java.util.Objects;

public class Prize {
    public static final int NAME_MAX_LENGTH = 5;
    public final String name;

    private Prize(String name) {
        this.name = name;
    }

    public static Prize of(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new NameLengthExceededException("상품의 이름은 " + NAME_MAX_LENGTH + "글자 이하여야 합니다.");
        }
        return new Prize(name);
    }

    public String value() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Prize)) {
            return false;
        }
        Prize prize = (Prize) o;
        return Objects.equals(name, prize.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
