package net.chandol.ladder.v2.domain.player;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Players implements Iterable<Player> {
    private List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public int size() {
        return players.size();
    }

    @Override
    public Iterator<Player> iterator() {
        return players.iterator();
    }

    public String createPlayersString() {
        return players.stream()
                .map(Player::getNameWithFixedLength)
                .collect(joining(" "));
    }

    public static Players of(String... names) {
        List<Player> rawPlayers = Arrays.stream(names).map(Player::new).collect(toList());
        return new Players(rawPlayers);
    }

    public static Players of(List<String> names) {
        List<Player> rawPlayers = names.stream().map(Player::new).collect(toList());
        return new Players(rawPlayers);
    }
}
