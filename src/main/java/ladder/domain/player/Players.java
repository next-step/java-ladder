package ladder.domain.player;

import ladder.context.ErrorMessage;

import java.util.*;
import java.util.stream.Collectors;

public class Players {
    private static final String NAMES_REGEX = ",";
    public static final int DEFAULT_INDEX = -1;

    private final List<Player> players;

    public Players(String names) {
        validEmpty(names);
        validDuplication(names);
        players = makePlayersList(names);
    }

    private void validEmpty(String names) {
        if (Objects.isNull(names) || names.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_NULL.getMessage());
        }
    }

    private Boolean isDuplication(String names) {
        return Arrays.stream(names.split(NAMES_REGEX))
                .map(String::trim)
                .allMatch(new HashSet<>()::add);
    }

    private void validDuplication(String names) {
        if (!isDuplication(names)) {
            throw new IllegalArgumentException(ErrorMessage.NAME_DULICATION.getMessage());
        }
    }

    private List<Player> makePlayersList(String names) {
        return Arrays.stream(names.split(NAMES_REGEX))
                .map(String::trim)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public int getPlayerCount() {
        return (int) players.stream()
                .map(Player::getName)
                .count();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int getIndexByName(String name) {
        return Optional.ofNullable(name)
                .map(Player::new)
                .map(players::indexOf)
                .filter(index -> index > DEFAULT_INDEX)
                .orElseThrow(() ->
                        new IllegalArgumentException(String.format("'%s'이름을 사용하는 플레이어는 존재하지 않습니다.", name))
                );
    }
}
