package net.chandol.domain.player;

import net.chandol.value.Positive;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Players {
    private List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public Players(String... players) {
        this.players = Arrays.stream(players).map(Player::new).collect(toList());
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Positive size() {
        return Positive.pos(players.size());
    }
}
