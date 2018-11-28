package net.chandol.domain.player;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Players implements Iterable<Player> {
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

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public int size() {
        return players.size();
    }

    @Override
    public Iterator<Player> iterator() {
        return this.players.iterator();
    }

    public Stream<Player> stream() {
        return this.players.stream();
    }


}
