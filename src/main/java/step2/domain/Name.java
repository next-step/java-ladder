package step2.domain;

import java.util.Objects;

class Name implements Printable {
    private final String name;

    Name(final String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (name.length() <= 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @Override
    public String print() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        final Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
