package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {
    private static final String SPILT_COMMA_AND_TRIM = "\\s*,\\s*";

    private final List<Name> players;

    public Players(List<Name> players) {
        this.players = players;
    }

    public static Players create(String names) {
        if (names == null || names.isBlank()) {
            throw new IllegalArgumentException("이름은 빈 값을 입력 할 수 없습니다.");
        }
        return new Players(splitNames(names));
    }

    private static ArrayList<Name> splitNames(String names) {
        String[] splitNames = names.split(SPILT_COMMA_AND_TRIM);

        ArrayList<Name> nameList = new ArrayList<>();
        for (String splitName : splitNames) {
            nameList.add(new Name(splitName));
        }
        return nameList;
    }

    public int countOfPlayers() {
        return players.size();
    }

    public List<Name> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
