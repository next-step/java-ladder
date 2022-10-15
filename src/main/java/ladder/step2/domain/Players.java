package ladder.step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<PlayerName> playerNames;
    
    public Players(final List<String> playerNames) {
        this.playerNames = initPlayers(playerNames);
    }
    
    private static List<PlayerName> initPlayers(final List<String> playerNames) {
        return playerNames.stream()
                .map(PlayerName::new)
                .collect(Collectors.toList());
    }
    
    @Override
    public String toString() {
        return "Players{" +
                "playerNames=" + playerNames +
                '}';
    }
}
