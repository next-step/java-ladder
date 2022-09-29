package ladder.step2.domain;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayerName {
    private final String playerName;
    private static final int TOTAL_NAME_LENGTH = 9;
    private static final String EMPTY = "";
    private static final String PLAYER_NAME_PRINT_FORM = "%%%ds%%%ds";
    
    public PlayerName(String playerName) {
        this.playerName = playerName;
    }
    
    private int getRightSpaceLength() {
        return (TOTAL_NAME_LENGTH - playerName.length()) / 2;
    }
    
    private int getLeftSpaceLength() {
        return getRightSpaceLength() + (TOTAL_NAME_LENGTH - playerName.length()) % 2 + playerName.length();
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
    
    @Override
    public String toString() {
        return String.format(String.format(PLAYER_NAME_PRINT_FORM, getLeftSpaceLength(), getRightSpaceLength()), playerName, EMPTY);
    }
}
