package game.ladder.domain;

import spark.utils.Assert;
import spark.utils.StringUtils;

public class Name {
    private static final int MIN_LENGTH = 5;
    private static final String FORMAT = "%6s";

    private final String value;

    public Name(String value) {
        Assert.isTrue(StringUtils.isNotBlank(value), "이름은 공백일 수 없습니다.");
        Assert.isTrue(value.length() <= MIN_LENGTH, "이름은 5자를 넘길 수 없습니다.");
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String fomattedName() {
        return String.format(FORMAT, this.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name name = (Name) o;

        return value.equals(name.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
