package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players from(List<String> playerList) {
        return new Players(playerList.stream().map(Player::from).collect(Collectors.toList()));
    }

    public List<Player> list() {
        return this.players;
    }

    public Player findPlayer(String playerName) {
        for (Player player : players) {
            if(playerName.equals(player.name())){
                return player;
            }
        }
        throw new IllegalArgumentException("해당 플레이어는 존재하지 않습니다.");
    }

    public int orderByPlayerName(String name) {
        return players.indexOf(findPlayer(name));
    }
}
