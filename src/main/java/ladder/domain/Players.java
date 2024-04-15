package ladder.domain;

import java.util.List;

public class Players {
    private List<Player> players;

    public Players(List<Player> players) {
        if (players.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("참가자는 최소 2명 이상이어야 합니다.");
        }
        this.players = players;
    }

    public int getCount() {
        return players.size();
    }

    public int getIndexOfPlayer(Player player){
        return players.indexOf(player);
    }

    public Player getPlayerByNameOrNull(String playerName) {
        if (playerName.equals(ALL_PLAYER)) {
            return null;
        }
        return new Player(playerName);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public static final int MIN_PLAYER_COUNT = 2;
    public static final String ALL_PLAYER = "ALL";
}
