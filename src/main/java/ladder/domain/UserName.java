package ladder.domain;

import java.util.Objects;

import static ladder.utils.Constants.*;

public class UserName {
    private final String name;

    public UserName(String name) {
        if (name.length() > NUMBER_FIVE) {
            throw new IllegalArgumentException(MSG_NAME_LENGTH_FIVE);
        }
        this.name = name;
    }

    public String getNameAndBlank() {
        if (name.length() == NUMBER_FIVE) {
            return name;
        }
        String nameAndBlank = name + SYMBOL_BLANK;
        if (name.length() == NUMBER_FOUR) {
            return nameAndBlank;
        }
        if (name.length() == NUMBER_THREE) {
            return SYMBOL_BLANK + nameAndBlank;
        }
        if (name.length() == NUMBER_TWO) {
            return SYMBOL_BLANK + SYMBOL_BLANK + nameAndBlank;
        }
        return SYMBOL_BLANK + SYMBOL_BLANK + SYMBOL_BLANK + nameAndBlank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName = (UserName) o;
        return Objects.equals(name, userName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
