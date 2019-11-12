package step2;

import java.util.Objects;

public class NameDot implements Dot {
    private final String name;

    public NameDot(final String name) {
        validate(name);
        this.name = name;
    }

    @Override
    public String print() {
        return name;
    }

    private void validate(final String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof NameDot)) return false;
        final NameDot nameDot = (NameDot) o;
        return Objects.equals(name, nameDot.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
