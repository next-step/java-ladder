package ladder.domain.prize;

import ladder.domain.name.Name;
import ladder.exception.ErrorMessage;

import java.util.Objects;

public class Prize {

    private final Name name;

    private Prize(final Name name) {
        verifyName(name);
        this.name = name;
    }

    public static Prize of(final String name) {
        return new Prize(Name.of(name));
    }

    private void verifyName(final Name name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prize)) return false;
        Prize prize = (Prize) o;
        return Objects.equals(name, prize.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
