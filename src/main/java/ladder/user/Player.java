package ladder.user;

import ladder.ladder.Position;

public class Player {

    private final UserName userName;
    private final Position position;

    public Player(UserName userName, Position position) {
        this.userName = userName;
        this.position = position;
    }

    public UserName getUserName() {
        return userName;
    }
}
