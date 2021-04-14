package step4.domain;


public class Player {
    private final PlayerName playerName;
    private final Position position;

    public Player(int number, String name) {
        position = Position.valueOf(number);
        playerName = new PlayerName(name);
    }

    public boolean isNameEqual(PlayerName playerName) {
        return true;
    }

}
