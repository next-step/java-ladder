package nextstep.ladder.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

    private static final String DUPLICATED_NAME = "중복된 참가자 이름은 존재할 수 없습니다";
    private static final String NON_EXISTENT_NAME = "존재하지 않는 참가자 이름입니다 -> %s";
    private static final String DELIMITER = ",";

    private final List<Player> players;

    public Players(final String names) {
        List<Player> players = Arrays.stream(names.split(DELIMITER))
                .map(Player::new)
                .collect(Collectors.toList());
        requireNoDuplicatedNames(players);
        this.players = players;
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public int count() {
        return players.size();
    }

    public List<Integer> getPositions(final WonderingPlayers wonderingPlayers) {
        return wonderingPlayers.getWonderingPlayers()
                .stream()
                .map(this::getPositions)
                .collect(Collectors.toList());
    }

    private int getPositions(final Player player) {
        return IntStream.range(0, count())
                .filter(i -> getPlayer(i).equals(player))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format(NON_EXISTENT_NAME, player)));
    }

    private Player getPlayer(final int position) {
        return players.get(position);
    }

    private void requireNoDuplicatedNames(final List<Player> players) {
        if (players.size() != new HashSet<>(players).size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME);
        }
    }

}
