package laddergame.domain.player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Players {
    private final List<Player> players;

    public Players(String[] names) {
        validateNames(names);
        validateDuplicatedNames(names);
        this.players = createPlayers(names);
    }

    private List<Player> createPlayers(String[] names) {
        return IntStream.range(0, names.length)
                .mapToObj(column -> new Player(names[column], column + 1))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    private void validateNames(final String[] names) {
        if (Objects.isNull(names) || names.length == 0) {
            throw new IllegalArgumentException("입력한 이름들이 Null 또는 빈 배열입니다.");
        }
    }

    private void validateDuplicatedNames(final String[] names) {
        int duplicatedSize = Arrays.stream(names)
                .map(String::trim)
                .collect(Collectors.toSet())
                .size();

        if (duplicatedSize != names.length) {
            throw new IllegalArgumentException("중복되는 이름이 존재합니다. - " + Arrays.toString(names));
        }
    }
}
