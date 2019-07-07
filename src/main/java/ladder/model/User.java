package ladder.model;

import ladder.enumset.Validation;

import java.util.Objects;

public class User {

    private static final String ALL_PRINT_SIGN = "all";
    private final String name;

    public User(String name) {
        this.name = nameValidation(name);
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

    private String nameValidation(String name) {
        if (name.length() > 5) {
            throw new IllegalStateException("사다리 게임 이용자의 이름은 다섯글자를 넘을 수 없습니다.");
        }
        return nameCharactersValidation(name);
    }

    private String nameCharactersValidation(String name) {
        if (Validation.NAME_VALIDATE.isInValid(name)) {
            throw new IllegalStateException("사다리 게임 이용자의 이름은 영문으로만 입력 할 수 있습니다.");
        }
        return name;
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
