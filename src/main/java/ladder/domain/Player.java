package ladder.domain;

public class Player {
    private static final int MAX_LENGTH_OF_PLAYER_NAME = 5;

    private final String player;

    public Player(String player) {
        validatePlayer(player);
        this.player = player;
    }

    private void validatePlayer(String player) {
        if (player == null || player.isEmpty()) {
            throw new IllegalArgumentException("player의 이름은 공백이나 null값이 될 수없습니다.");
        }

        if (player.length() > MAX_LENGTH_OF_PLAYER_NAME) {
            throw new IllegalArgumentException("player의 이름은 최대 5글자를 초과 할 수 없습니다.");
        }
    }

    public String getPlayer() {
        return player;
    }
}
