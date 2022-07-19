package ladder.domain;

import java.util.*;

public class Players {
    private static final String SPILT_COMMA_AND_TRIM = "\\s*,\\s*";

    private Map<PlayerName, String> players;

    public Players(String playerNames) {
        this(splitNames(playerNames));
    }

    public Players(Map<PlayerName, String> players) {
        this.players = players;
    }

    private static Map<PlayerName, String> splitNames(String playerNames) {
        if (playerNames == null || playerNames.isBlank()) {
            throw new IllegalArgumentException("이름은 빈 값을 입력 할 수 없습니다.");
        }

        String[] splitNames = playerNames.split(SPILT_COMMA_AND_TRIM);

        Map<PlayerName, String> nameMap = new LinkedHashMap<>();
        int index = 0;
        for (String splitName : splitNames) {
            nameMap.put(new PlayerName(splitName), String.valueOf(index++));
        }
        return nameMap;
    }

    public int countOfPlayers() {
        return players.size();
    }

    public Map<PlayerName, String> getPlayers() {
        return players;
    }
}
