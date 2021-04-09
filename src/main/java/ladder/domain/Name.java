/*
 * 사다리타기 게임 참여자의 이름을 담당하는 클래스
 * */
package ladder.domain;

import java.util.Objects;

import static ladder.util.Message.ILLEGAL_NAME;

public class Name {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validName(name);
        this.name = name;
    }

    public boolean validName(String name) {
        if (emptyName(name) || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ILLEGAL_NAME);
        }
        return true;
    }

    private boolean emptyName(String name) {
        if (name == null || name.isEmpty() || name.equals("")) {
            return true;
        }
        return false;
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
