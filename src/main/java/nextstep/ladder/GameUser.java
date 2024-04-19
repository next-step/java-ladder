package nextstep.ladder;

import nextstep.ladder.domain.Line;

public class GameUser {
    private String userName;
    private Position position;

    public GameUser(String userName, Position position) {
        this.userName = userName;
        this.position = position;
    }

    public void move(Line line) {
        if (line.rightIsMovable(this.position)) {
            this.position.rightMove();
        } else if (line.leftIsMovable(this.position)) {
            this.position.leftMove();
        }
    }

    public Position getPosition() {
        return position;
    }

    public String getUserName() {
        return userName;
    }

}
