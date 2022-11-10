package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    public static final String DELIMITER = ",";
    private final List<Player> players;

    public Players(String names) {
        validateNullOrEmpty(names);
        this.players = parse(names);
    }

    private List<Player> parse(String names) {
        String[] tokens = split(names);
        return Arrays.stream(tokens)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private String[] split(String names) {
        return names.split(DELIMITER);
    }

    private void validateNullOrEmpty(String names) {
        if (Objects.isNull(names) || names.isEmpty()) {
            throw new LadderGameException(ErrorCode.NULL_OR_EMPTY_INPUT);
        }
    }

    public List<Player> getPlayers() {
        return this.players;
    }
}
