package ladder.step2.domain;

import ladder.step2.exception.PlayerNameLengthExceededException;

public class PlayerName {
    private static final int MAX_LENGTH_OF_PLAYER_NAME = 5;
    
    private final String playerName;
    
    public PlayerName(final String playerName) {
        if (playerName.length() > MAX_LENGTH_OF_PLAYER_NAME) {
            throw new PlayerNameLengthExceededException();
        }
        this.playerName = playerName;
    }
    
    @Override
    public String toString() {
        return "PlayerName{" +
                "playerName='" + playerName + '\'' +
                '}';
    }
}
