/*
 * 사다리타기 게임 참여자의 이름을 담당하는 클래스
 * */
package step4.laddergame.domain.player;

import java.util.Objects;

public class Name {
    private static final String ILLEGAL_NAME = "이름은 1~5자 사이여야합니다.";
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validName(name);
        this.name = name;
    }

    public void validName(String name) {
        if (isEmpty(name) || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ILLEGAL_NAME);
        }
    }

    private boolean isEmpty(String name) {
        return name == null || name.isEmpty() || name.equals("");
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
        return new StringBuilder()
                .append(name)
                .toString();
    }
}
