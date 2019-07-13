package ladder.model;

import ladder.utils.ReferenceValue;
import ladder.utils.Validation;

import java.util.Objects;

public class User {

    private static final String ALL_PRINT_SIGN = "all";
    private final String name;

    public User(String name) {
        validationNameLength(name);
        nameCharactersValidation(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAllPrintSignUser() {
        return this.name.equals(ALL_PRINT_SIGN);
    }

    public int getNameLength() {
        return this.name.length();
    }

    private void validationNameLength(String name) {
        if (ReferenceValue.NAME_LENGTH.isInValidNameLength(name)) {
            throw new IllegalStateException("사다리 게임 이용자의 이름은 다섯글자를 넘을 수 없습니다.");
        }
    }

    private void nameCharactersValidation(String name) {
        if (Validation.NAME_VALIDATE.isInValid(name)) {
            throw new IllegalStateException("사다리 게임 이용자의 이름은 영문으로만 입력 할 수 있습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
