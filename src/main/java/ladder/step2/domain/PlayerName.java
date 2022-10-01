package ladder.step2.domain;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayerName {
    private static final String PLAYER_NAME_LENGTH_EXCEPTION_MESSAGE = "플레이어 이름은 5자를 초과할 수 없습니다.";
    private static final String PLAYER_NAME_PRINT_FORM = "%%%ds%%%ds";
    private static final String EMPTY = "";
    private static final int PLAYER_NAME_MAX_LENGTH = 5;
    private static final int TOTAL_NAME_LENGTH = 9;
    private static final int TWO = 2;
    
    private final String playerName;
    
    public PlayerName(String playerName) {
        if (playerName.length() > PLAYER_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(PLAYER_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
        
        this.playerName = playerName;
    }
    
    private int getLeftSpaceLength() {
        return getRightSpaceLength() + (TOTAL_NAME_LENGTH - playerName.length()) % TWO + playerName.length();
    }
    
    private int getRightSpaceLength() {
        return (TOTAL_NAME_LENGTH - playerName.length()) / TWO;
    }
    
    @Override
    public String toString() {
        return String.format(String.format(PLAYER_NAME_PRINT_FORM, getLeftSpaceLength(), getRightSpaceLength()), playerName, EMPTY);
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
