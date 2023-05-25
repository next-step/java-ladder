package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {
    private List<Player> players = new ArrayList<Player>();

    public Players(String[] names) {
        for (int i = 0; i < names.length; i++) {
            players.add(new Player(i, names[i]));
        }
    }

    public List<Player> getPlayers(){
        return Collections.unmodifiableList(players);
    }

    public int playerSequence(String name){
        return players.stream()
                .filter( player -> player.getName().equals(name))
                .map( Player::getSequence)
                .findAny().get();
    }

    public int size() {
        return players.size();
    }

}
