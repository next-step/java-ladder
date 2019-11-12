package step2.domain;

import java.util.Objects;

class NameDot implements Dot {
    private final Name name;

    NameDot(final String name) {
        this.name = new Name(name);
    }

    @Override
    public String print() {
        return name.print();
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
