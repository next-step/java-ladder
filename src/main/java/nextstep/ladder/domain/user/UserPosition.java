package nextstep.ladder.domain.user;

import nextstep.ladder.domain.line.Point;
import nextstep.ladder.error.exception.UserPositionZeroException;

public class UserPosition {

    private int userPosition;

    public UserPosition(int userPosition) {
        this.userPosition = userPosition;
    }

    public int canMoveRight(Point point){
        return userPosition++;
    }

    public int canMoveLeft(Point point){
        if (userPosition <= 0){
            throw new UserPositionZeroException(userPosition);
        }
        return userPosition--;
    }
}
