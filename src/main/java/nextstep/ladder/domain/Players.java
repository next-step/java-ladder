package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    public Players(String nameString) {
        this.players = init(nameString);
    }

    private List<Player> init(String nameString) {
        List<Player> playerList = new ArrayList<>();
        String[] carNameArray = nameString.split(",");

        Arrays.stream(carNameArray)
                .map(name -> playerList.add(new Player(name.trim()))).collect(Collectors.toList());

        return playerList;
    }

    public List<Player> getPlayers() {
        return players;
    }
    public int numberOfPlayers() {
        return players.size();
    }

}
