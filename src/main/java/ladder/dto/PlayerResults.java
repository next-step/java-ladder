package ladder.dto;

import java.util.List;

public class PlayerResults {
    private List<PlayerResult> playerResults;

    public PlayerResults(List<PlayerResult> playerResults){
        this.playerResults = playerResults;
    }

    public String getResultValueByPlayerName(String playerName){
        return playerResults.stream()
                .filter(playerResult -> playerResult.getPlayer().equalsName(playerName))
                .map(playerResult -> playerResult.getResult().getResultValue())
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<PlayerResult> getPlayerResults(){
        return this.playerResults;
    }
}
