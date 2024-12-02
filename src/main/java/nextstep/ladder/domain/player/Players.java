package nextstep.ladder.domain.player;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        if (players.size() < 2) {
            throw new IllegalArgumentException("게임 참가자는 2명 이상이어야 합니다.");
        }

        this.players = players;
    }

    public int playerCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int findIndexByName(String playerName) {
        Optional<Player> findedPlayer = players.stream()
                                               .filter(player -> player.equals(new Player(playerName)))
                                               .findFirst();

        if (findedPlayer.isEmpty()) {
            throw new NoSuchElementException("[" + playerName + "] 존재하지 않는 플레이어입니다.");
        }

        return players.indexOf(findedPlayer.get());
    }

}
