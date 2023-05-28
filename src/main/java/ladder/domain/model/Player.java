package ladder.domain.model;

public class Player {
    private static final int LEFT = -1;
    private static final int RIGHT = 1;
    private PlayerName playerName;
    private int point;

    public Player(PlayerName playerName, int result) {
        this.playerName = playerName;
        this.point = result;
    }

    public boolean equalPlayerName(String playerName) {
        return this.playerName
                .getName()
                .trim()
                .equals(playerName);
    }

    public void move(Lines lines) {
        lines.getLines().forEach(line -> {
            if (line.isPointFullLeft(point) && line.isRightConnect(point)) {
                moveRight();
                return;
            }

            if (line.isPointFullLeft(point)) {
                return;
            }

            if (line.isPointFullRight(point) && line.isLeftConnect(point)) {
                moveLeft();
                return;
            }

            if (line.isPointFullRight(point)) {
                return;
            }

            move(line);
        });
    }

    public void moveLeft() {
        point += LEFT;
    }

    public void moveRight() {
        point += RIGHT;
    }

    public void move(Line line) {
        if (line.isLeftConnect(point)) {
            moveLeft();
            return;
        }
        if (line.isRightConnect(point)) {
            moveRight();
        }
    }

    public int getPoint() {
        return point;
    }

    public String getPlayerName() {
        return playerName.getName();
    }
}
