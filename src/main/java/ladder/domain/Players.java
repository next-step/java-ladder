package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {

    public static final String DELIMITER = ",";
    private final List<PlayerName> playerNames;


    public Players(List<PlayerName> playerNames) {
        this.playerNames = playerNames;
    }

    public Players(String names) {
        this(toNames(names));
    }

    public int size() {
        return playerNames.size();
    }

    private static List<PlayerName> toNames(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList())
                .stream()
                .map(PlayerName::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players = (Players) o;
        return Objects.equals(playerNames, players.playerNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerNames);
    }

    public List<PlayerName> names() {
        return Collections.unmodifiableList(playerNames);
    }
}
