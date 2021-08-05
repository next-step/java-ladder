package ladder.domain;

import java.util.Objects;

public final class Prize {
    private final Name name;

    public Prize(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Prize prize = (Prize) o;
        return Objects.equals(name, prize.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
