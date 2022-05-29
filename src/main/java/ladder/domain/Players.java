package ladder.domain;

import java.util.*;

public class Players {
    private static final String SPILT_COMMA_AND_TRIM = "\\s*,\\s*";

    private Map<Name, String> players;

    public Players(String names) {
        this(splitNames(names));
    }

    public Players(Map<Name, String> players) {
        this.players = players;
    }

    private static Map<Name, String> splitNames(String names) {
        if (names == null || names.isBlank()) {
            throw new IllegalArgumentException("이름은 빈 값을 입력 할 수 없습니다.");
        }

        String[] splitNames = names.split(SPILT_COMMA_AND_TRIM);

        Map<Name, String> nameMap = new LinkedHashMap<>();
        for (String splitName : splitNames) {
            nameMap.put(new Name(splitName), "");
        }
        return nameMap;
    }

    public int countOfPlayers() {
        return players.size();
    }

    public Map<Name, String> getPlayers() {
        return Collections.unmodifiableMap(players);
    }
}
