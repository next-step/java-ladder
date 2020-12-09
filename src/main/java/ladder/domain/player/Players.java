package ladder.domain.player;

import ladder.context.ErrorMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    private static final String NAMES_REGEX = ",";

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

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public int getPlayerCount() {
        return (int) players.stream()
                .map(Player::getName)
                .count();
    }
}
