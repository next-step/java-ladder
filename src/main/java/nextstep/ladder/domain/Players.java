package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.exception.LadderExceptionMessage.CHECK_NAME_DUPLICATION;
import static nextstep.ladder.utils.StringUtil.splitWithComma;

public class Players {
    private final List<Player> players;

    public Players(String names) {
        this(convertToPlayers(splitWithComma(names)));
    }

    private static List<Player> convertToPlayers(List<String> names) {
        return names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public Players(String... names) {
        this(convertToPlayers(names));
    }

    private static List<Player> convertToPlayers(String[] names) {
        return Arrays.stream(names)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public Players(List<Player> players) {
        validateDuplication(players);
        this.players = players;
    }

    private void validateDuplication(List<Player> players) {
        if (players.size() != new HashSet<>(players).size()) {
            throw new LadderException(CHECK_NAME_DUPLICATION);
        }
    }

    public List<Player> allPlayers() {
        return players;
    }

    public List<String> names() {
        return players.stream()
                .map(Player::name)
                .collect(Collectors.toList());
    }

    public CountOfPlayer countOfPlayer() {
        return new CountOfPlayer(players.size());
    }
}