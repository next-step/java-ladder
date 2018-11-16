package domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Laddering {
    private List<Player> players;
    private List<Line> lines;

    public Laddering(List<Player> players, List<Line> lines) {
        this.players = players;
        this.lines = lines;
    }


    public List<PlayResult> showResult(String playerName, LadderResult ladderResult) {
        List<PlayResult> ladderResults = new ArrayList<>();
        if(playerName.equals("all")){
            for(Player player : players){
                int location = players.indexOf(player);
                for(Line line : lines){
                    location = line.Move(location);
                }
                ladderResults.add(new PlayResult(player ,ladderResult.getResult(location)));
            }
        }else{
            Player player = new Player(playerName);
            int location = players.indexOf(player);
            for(Line line : lines){
                location = line.Move(location);
            }
            ladderResults.add(new PlayResult(player ,ladderResult.getResult(location)));
        }
        return ladderResults;
    }
}
