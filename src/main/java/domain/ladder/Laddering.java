package domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Laddering {
    private List<Player> players;
    private List<Line> lines;

    Laddering(List<Player> players, List<Line> lines) {
        this.players = players;
        this.lines = lines;
    }

    public List<PlayResult> showResult(String playerName, LadderResult ladderResult) {
        List<PlayResult> playResults;
        if(playerName.equals("all")){
            playResults = AllPlayerResult(ladderResult);
        }else{
            playResults =  playerResult(playerName, ladderResult);
        }
        return playResults;
    }

    private List<PlayResult> playerResult(String playerName, LadderResult ladderResult) {
        List<PlayResult> playResults = new ArrayList<>();
        Player player = new Player(playerName);
        int location = players.indexOf(player);
        location = getLocation(location);
        playResults.add(new PlayResult(player ,ladderResult.getResult(location)));
        return playResults;
    }

    private List<PlayResult> AllPlayerResult(LadderResult ladderResult) {
        List<PlayResult> playResults = new ArrayList<>();
        for(Player player : players){
            int location = players.indexOf(player);
            location = getLocation(location);
            playResults.add(new PlayResult(player ,ladderResult.getResult(location)));
        }
        return playResults;
    }
    private int getLocation(int location) {
        int resultLocation = location;
        for (Line line : lines) {
            resultLocation = line.Move(resultLocation);
        }
        return resultLocation;
    }
}
