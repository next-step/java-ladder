package step2.domain;

import step2.exception.IllegalPlayerName;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Players {
    public static final String SPLIT_COMMA = ",";
    public static final String ALL_PLAYERS = "all";

    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(String players) {
        String[] splitPlayers = players.split(SPLIT_COMMA);

        return IntStream.range(0, splitPlayers.length)
                .mapToObj(index -> new Player(splitPlayers[index], new Position(index)))
                .collect(collectingAndThen(toList(), Players::new));
    }

    public int getSize() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public List<Player> getPlayersByName(String playerName) {
        if (playerName.equals(ALL_PLAYERS)) {
            return getPlayers();
        }

        return Arrays.asList(
                players.stream()
                        .filter(player -> playerName.equals(player.getName()))
                        .findFirst()
                        .orElseThrow(() -> new IllegalPlayerName("잘못된 플레이어 이름입니다.")));
    }

    public Players getResult(Lines lines) {
        return players.stream()
                .map(player ->
                        new Player(
                                player.getName(),
                                lines.getResultPosition(player.getPosition())))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Players::new));
    }
}
