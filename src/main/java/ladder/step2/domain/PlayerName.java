package ladder.step2.domain;

import ladder.step2.dto.PlayerNameDTO;

import java.util.Objects;

public class PlayerName {
    private static final String PLAYER_NAME_LENGTH_EXCEPTION_MESSAGE = "플레이어 이름은 5자를 초과할 수 없습니다.";
    private static final int PLAYER_NAME_MAX_LENGTH = 5;
    
    private final String playerName;
    
    public PlayerName(String playerName) {
        if (playerName.length() > PLAYER_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(PLAYER_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
        
        this.playerName = playerName;
    }
    
    public PlayerNameDTO playerNameInformation() {
        return new PlayerNameDTO(playerName);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerName that = (PlayerName) o;
        return Objects.equals(playerName, that.playerName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }
}
