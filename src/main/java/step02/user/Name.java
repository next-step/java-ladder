package step02.user;

import step02.exception.OutOfNameLengthException;

import java.util.Objects;

public class Name {
    private final static String ERROR_NAME_LENGTH = "이름은 %d~%d글자 이내로 입력해주세요";
    private final static int MAX_LENGTH = 5;
    private final static int MIN_LENGTH = 1;
    private final static int ZERO = 0;

    private final String name;

    public Name(String name) throws OutOfNameLengthException {
        checkNameLength(name);
        this.name = name;
    }

    private void checkNameLength(String name) throws OutOfNameLengthException {
        if (name.length() <= ZERO || name.length() > MAX_LENGTH) {
            throw new OutOfNameLengthException(String.format(ERROR_NAME_LENGTH, MIN_LENGTH, MAX_LENGTH));
        }
    }

    public String getName() {
        return name;
    }

    public int getNameLength() {
        return name.length();
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
