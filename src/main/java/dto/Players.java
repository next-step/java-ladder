package dto;

import java.lang.instrument.IllegalClassFormatException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Players {

    private List<Player> players;

    public Players(String playerNames) {
        this.players = splitComma(playerNames);
    }

    List<Player> splitComma(String playerNames){
        if(playerNames.equals(null) || !playerNames.contains(",")){
            throw new IllegalArgumentException();
        }
        return Stream.of(playerNames.split(",")).map(e -> new Player(e)).collect(Collectors.toList());
    }

    public int size() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player nthPlayer(int n){
        return this.players.get(n);
    }

    public Player hasPlayer(String name){
        for(Player player : this.players){
            if(player.equals(name)){
                return player;
            }
        }
        return null;
    }
}
