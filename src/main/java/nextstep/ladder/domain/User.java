package nextstep.ladder.domain;

import java.util.Objects;

public class User {

    private static final String INVALID_USER_NAME_LENGTH = "사다리 게임에 참여하는 사람에 이름을 최대 5글자까지 부여할 수 있습니다.";

    private String name;
    private Integer currentPosition;

    public User(String name, Integer currentPosition) {
        validateName(name);
        this.name = name;
        this.currentPosition = currentPosition;
    }

    private void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(INVALID_USER_NAME_LENGTH);
        }
        name = name.trim();
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException(INVALID_USER_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    public Boolean moveLeft() {
        if (currentPosition - 1 >= 0) {
            currentPosition--;
            return true;
        }
        return false;
    }

    public Boolean moveRight() {
        currentPosition++;
        return true;
    }

    public Integer getCurrentPosition() {
        return currentPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return name.equals(user.name) &&
            currentPosition.equals(user.currentPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, currentPosition);
    }

    @Override
    public String toString() {
        return "User{" +
            "name='" + name + '\'' +
            ", currentPosition=" + currentPosition +
            '}';
    }
}
