package step4.domain.user;

import java.util.Objects;
import step4.exception.user.NameBlankException;
import step4.exception.user.NameLengthException;
import step4.util.StringUtil;

public class Name {

    private static final int NAME_MAX_LENGTH = 3;

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name of(String name){
        checkNameBlank(name);
        checkNameLength(name);

        return new Name(name);
    }

    private static void checkNameBlank(String name) {
        if (Objects.isNull(name) || StringUtil.isBlank(name)) {
            throw new NameBlankException();
        }
    }

    private static void checkNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new NameLengthException();
        }
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
    public int hashCode() {
        return Objects.hash(name);
    }

}
