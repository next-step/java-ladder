package step3.ladderGame.domain.palyer;

import step3.ladderGame.domain.exception.NotFoundIndexException;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class Players {

    private final List<Player> players;

    public Players(final List<String> playerNames) {
        AtomicInteger index = new AtomicInteger();

        players = playerNames.stream()
                .map(name -> new Player(name, index.getAndIncrement()))
                .collect(Collectors.toList());
    }

    public int findIndex(final String name) {
        return players.stream()
                .filter(player -> name.equals(player.getName()))
                .findFirst()
                .map(Player::getIndex)
                .orElseThrow(NotFoundIndexException::new);
    }

    public List<Player> getPlayers() {
        return players;
    }

}
