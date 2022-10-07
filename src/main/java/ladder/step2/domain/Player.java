package ladder.step2.domain;

import ladder.step2.dto.PlayerDTO;

public class Player {
    private static final String PLAYER_NAME_LENGTH_EXCEPTION_MESSAGE = "플레이어 이름은 5자를 초과할 수 없습니다.";
    private static final int PLAYER_NAME_MAX_LENGTH = 5;
    
    private final String playerName;
    
    public Player(String playerName) {
        if (playerName.length() > PLAYER_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(PLAYER_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
        
        this.playerName = playerName;
    }
    
    public String getPlayerName() {
        return playerName;
    }
}
