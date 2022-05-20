package nextstep.ladder.domain;

import java.util.Objects;
import nextstep.ladder.utils.StringUtils;

public class Name {

    public static final int MINIMUM_NAME_LENGTH = 1;
    public static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (StringUtils.isEmpty(name)
        || name.length() < MINIMUM_NAME_LENGTH
        || name.length() > MAXIMUM_NAME_LENGTH)
            throw new IllegalArgumentException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean is(String name) {
        return this.name.equals(name);
    }

    public String get() {
        return name;
    }

}
