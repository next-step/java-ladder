package nextstep.ladder.domain;

import java.util.Objects;
import nextstep.ladder.exception.InputNullPointerException;
import nextstep.ladder.exception.NameSizeOverBoundException;

public abstract class AbstractString {

    private static final int STRING_MAXIMUM_SIZE = 5;

    protected final String string;

    protected AbstractString(String string) {
        valid(string);
        this.string = string;
    }

    private static void valid(String string) {
        if (string == null || string.isEmpty()) {
            throw new InputNullPointerException();
        }

        if (string.length() > STRING_MAXIMUM_SIZE) {
            throw new NameSizeOverBoundException(STRING_MAXIMUM_SIZE);
        }
    }

    public int length() {
        return string.length();
    }

    @Override
    public String toString() {
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractString that = (AbstractString) o;
        return Objects.equals(string, that.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string);
    }

}
