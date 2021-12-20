package ladder.model.player;

import ladder.model.name.Names;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final String RESULT_OF_ALL = "ALL";
    private static final int MIN_PLAYER_COUNT = 2;
    private final List<Player> players;

    public Players(String players) {
        this.players = new Names(players).get()
                .stream()
                .map(Player::new)
                .collect(Collectors.toList());
        checkValidation(this.players);
    }

    private void checkValidation(List<Player> players) {
        if(players.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("게임을 하려면 최소 " + MIN_PLAYER_COUNT + "명이 필요합니다.");
        }
    }

    public int count() {
        return this.players.size();
    }

    public int indexOf(Player player) {
        return players.indexOf(player);
    }

    public List<Player> getResultOf(String resultOf) {
        if(resultOf.equalsIgnoreCase(RESULT_OF_ALL)) return getAllPlayers();
        return getPlayerByName(resultOf);
    }

    public List<Player> getAllPlayers() {
        return Collections.unmodifiableList(this.players);
    }

    public List<Player> getPlayerByName(String name) {
        return players.stream()
                .filter(player -> player.isName(name))
                .collect(Collectors.toList());
    }

    public boolean contains(String resultOf) {
        return players.contains(new Player(resultOf));
    }
}
