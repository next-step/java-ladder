package ladder.domain.participants;

import ladder.utils.LambdaUtils;

import java.util.Objects;

public class Name {

    private final String text;
    public static final int MAX_NAME_LENGTH = 5;

    public Name(String name) {
        LambdaUtils.validateLength(name, MAX_NAME_LENGTH, (str, number) -> str.length() > number);
        this.text = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name = (Name) o;
        return Objects.equals(text, name.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return text;
    }
}
