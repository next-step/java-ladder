package ladder.domain.game;

import java.util.Objects;

/**
 * Created By mand2 on 2020-12-03.
 */
public class Name {

    public static final int NAME_LEN = 5;
    public static final String MESSAGE_NAME_NOT_NULL = "이름은 빈 칸이 될 수 없습니다.";
    public static final String MESSAGE_NAME_LEN_FIVE = "이름은 5자 이내여야 합니다.";

    private final String name ;

    private Name(String name) {
        this.name = name;
    }

    public static Name from(String inputName) {
        checkNull(inputName);
        checkLength(inputName);

        return new Name(inputName);
    }

    private static void checkNull(String inputName) {
        if (Objects.isNull(inputName) || inputName.isEmpty()) {
            throw new IllegalArgumentException(MESSAGE_NAME_NOT_NULL);
        }
    }

    private static void checkLength(String inputName) {
        if (NAME_LEN < inputName.length()) {
            throw new IllegalArgumentException(MESSAGE_NAME_LEN_FIVE);
        }
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

    @Override
    public String toString() {
        return name;
    }
}
