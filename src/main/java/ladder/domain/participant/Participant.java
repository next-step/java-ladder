package ladder.domain.participant;

import ladder.exception.InValidUserNameException;
import ladder.util.StringUtility;

import java.util.Objects;

public class Participant {

    private static final int USERNAME_LENGTH = 5;

    private final String userName;
    private Position position;

    public Participant(String userName, int startPosition) {
        validateUserName(userName);
        this.userName = userName;
        this.position = Position.from(startPosition);
    }

    private void validateUserName(String userName) {
        if (StringUtility.isBlank(userName) || userName.length() > USERNAME_LENGTH) {
            throw new InValidUserNameException(userName);
        }
    }

    public void movePosition(int direction){
        Position newPosition = this.position.move(direction);
        this.position = newPosition;
    }

    public String getUserName() {
        return userName;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(userName, that.userName) &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, position);
    }


}
