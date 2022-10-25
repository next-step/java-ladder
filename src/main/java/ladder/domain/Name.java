package ladder.domain;

import java.util.Objects;

public class Name {
    private final String name;

    public static final int MAX_NAME_LENGTH = 5;
    public static final String NAME_BLANK_APPENDER = " ";
    public static final String ERR_MSG_MAX_NAME_LENGTH = "이름은 최대 5글자까지 부여할 수 있습니다.";

    public Name(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERR_MSG_MAX_NAME_LENGTH);
        }
        this.name = name;
    }

    public String getResultName() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.name);
        while (builder.length() <= MAX_NAME_LENGTH) {
            builder.append(NAME_BLANK_APPENDER);
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
