package ladder.domain.user;

import static ladder.utils.StringUtils.isNullOrEmpty;

import java.util.Objects;
import ladder.domain.Position;
import ladder.exception.LadderGameException;

public class User {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_SHOULD_NOT_NULL_OR_EMPTY = "참가자의 이름이 공백입니다.";
    private static final String NAME_LENGTH_CAN_NOT_OVER_N = "참가자 이름의 길이가 %d자 이하로 작성해야 합니다.";

    private final String name;

    private final Position startPosition;

    public User(String name, Position startCoordinate) {
        validateName(name);
        this.name = name;
        this.startPosition = startCoordinate;
    }

    public String getName() {
        return name;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    private void validateName(String name) {
        if(isNullOrEmpty(name)) {
            throw new LadderGameException(NAME_SHOULD_NOT_NULL_OR_EMPTY);
        }
        if(isOverMaxNameLength(name)) {
            throw new LadderGameException(String.format(NAME_LENGTH_CAN_NOT_OVER_N, MAX_NAME_LENGTH));
        }
    }

    private boolean isOverMaxNameLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
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
        return Objects.equals(name, user.name) &&
            Objects.equals(startPosition, user.startPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startPosition);
    }
}
