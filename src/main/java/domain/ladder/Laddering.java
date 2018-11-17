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
            playResults =  playerResult(new Player(playerName), ladderResult);
        }
        return playResults;
    }

    private List<PlayResult> playerResult(Player player, LadderResult ladderResult) {
        List<PlayResult> playResults = new ArrayList<>();
        playResults.add(setResult(player, ladderResult.getResult(getLocation(players.indexOf(player)))));
        return playResults;
    }

    private PlayResult setResult(Player player, String result) {
        return new PlayResult(player, result);
    }

    private List<PlayResult> AllPlayerResult(LadderResult ladderResult) {
        List<PlayResult> playResults = new ArrayList<>();
        for(Player player : players){
            playResults.add(setResult(player, ladderResult.getResult(getLocation(players.indexOf(player)))));
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
