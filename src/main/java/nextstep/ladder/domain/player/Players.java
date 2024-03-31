package nextstep.ladder.domain.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players = new ArrayList<>();

    public Players(String[] playerNames) {
        this(Arrays.stream(playerNames)
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    public Players(List<Player> players) {
        assertPlayersNotEmpty(players);
        assertPlayerNamesNotDuplicated(players);

        this.players.addAll(players);
    }

    private void assertPlayersNotEmpty(List<Player> players) {
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException("참가자 이름을 입력해주세요.");
        }
    }

    private void assertPlayerNamesNotDuplicated(List<Player> players) {
        if (players.size() != distinctNameSize(players)) {
            throw new IllegalArgumentException("참가자 이름은 중복될 수 없습니다.");
        }
    }

    private int distinctNameSize(List<Player> players) {
        return (int) players.stream()
                .map(Player::name)
                .distinct()
                .count();
    }

    public Count count() {
        return new Count(players.size());
    }

    public Count maxNameLength() {
        return new Count(players.stream()
                .mapToInt(player -> player.name().length())
                .max()
                .orElse(0));
    }

    public List<String> playerNames() {
        return players.stream()
                .map(Player::name)
                .collect(Collectors.toList());
    }
}
