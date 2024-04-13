package nextstep.ladder.domain.player;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private static final String ALL_PLAYERS = "all";

    private final List<Player> players = new ArrayList<>();

    public static Players from(List<String> playerNames) {
        return new Players(
                Optional.ofNullable(playerNames)
                        .map(names -> IntStream.range(0, playerNames.size())
                                .mapToObj(index -> new Player(playerNames.get(index), index))
                                .collect(Collectors.toList()))
                        .orElse(Collections.emptyList()));
    }

    public Players(Player player) {
        this(List.of(player));
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
                .map(player -> player.name().value())
                .collect(Collectors.toList());
    }

    public List<Player> values() {
        return players;
    }

    public Players targetPlayers(String name) {
        if (ALL_PLAYERS.equals(name)) {
            return this;
        }
        return new Players(findByName(name));
    }

    public Player findByName(String name) {
        return players.stream()
                .filter(player -> player.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("참가자를 찾을 수 없습니다."));
    }

    public boolean contains(String name) {
        return playerNames().contains(name);
    }
}
