package ladder.domain;

import ladder.utils.StringUtils;

import java.util.Objects;

public class Attendee {

    private String name;
    private static final String ALL = "all";

    private Attendee(String name) {
        if(!isValidName(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public static Attendee create(String name) {
        return new Attendee(name);
    }

    private boolean isValidName(String name) {
        return name.length() < 6;
    }

    public boolean isAll() {
        return this.name.equals(ALL);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendee attendee = (Attendee) o;
        return Objects.equals(name, attendee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return StringUtils.center(name);
    }
}
