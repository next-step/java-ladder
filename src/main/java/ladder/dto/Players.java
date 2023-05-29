package ladder.dto;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private List<PlayerName> playerNames;

    public Players(){
        this.playerNames = new ArrayList<>();
    }

    public Players(List<String> names){
        List<PlayerName> playerNames = new ArrayList<>();
        names.forEach(name -> playerNames.add(new PlayerName(name)));
        this.playerNames = playerNames;
    }

    public int getCountOrPerson(){
        return this.playerNames.size();
    }

    public String getPlayerName(int idx){
        return this.playerNames.get(idx).getName();
    }
}
