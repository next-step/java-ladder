package nextstep.ladder.common;

import nextstep.ladder.utils.StringUtils;

import java.util.Objects;

public abstract class Name {

    public static final String DRAWING_NAME_FORMAT = "%5s";
    public static final String BLANK_DELIMITER = " ";

    private final String name;

    public Name(String name) {
        this.name = validation(StringUtils.validationNotNullAndEmpty(name));
    }

    protected abstract String validation(String name);

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
