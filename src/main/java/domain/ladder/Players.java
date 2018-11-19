package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Players {
    private List<Player> players;

    public Players(List<Player> players) {
        this.players = new ArrayList<>();
        for(Player player : players){
            this.players.add(player);
        }
    }

    public int getPlayerLocation(String playerName) {
        return players.indexOf(this.players.stream().filter(player -> player.findName(playerName)).findFirst().orElseThrow(IllegalArgumentException::new));
    }

    public Player findPlayLocation(int playerLocation) {
        return players.get(playerLocation);
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    @Override
    public String toString() {
        return "Players{" +
                "players=" + players +
                '}';
    }
}
