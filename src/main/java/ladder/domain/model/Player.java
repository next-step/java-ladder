package ladder.domain.model;

import java.util.List;

public class Player {
    private PlayerName playerName;
    private int result;

    public Player(PlayerName playerName, int result) {
        this.playerName = playerName;
        this.result = result;
    }

    public boolean equalPlayerName(String playerName) {
        return this.playerName
                .getName()
                .trim()
                .equals(playerName);
    }

    public enum Direction {
        LEFT(-1),
        RIGHT(1);

        private final int value;

        Direction(int value) {
            this.value = value;
        }

    }

    public void moveLeft(List<Boolean> points) {
        if (points.get(result - 1)) {
            result += Direction.LEFT.value;
        }
    }

    public void moveRight(List<Boolean> points) {
        if (points.get(result)) {
            result += Direction.RIGHT.value;
        }
    }

    public void move(List<Boolean> points) {
        if (points.get(result - 1)) {
            result += Direction.LEFT.value;
            return;
        }
        if (points.get(result)) {
            result += Direction.RIGHT.value;
        }
    }

    public int getResult() {
        return result;
    }

    public String getPlayerName() {
        return playerName.getName();
    }
}
