package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.utils.StringUtil.splitWithComma;

public class Players {
    private static final String CHECK_DUPLICATION = "중복되는 이름의 플레이어가 존재하는 지 확인해주세요.";

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
            throw new IllegalArgumentException(CHECK_DUPLICATION);
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