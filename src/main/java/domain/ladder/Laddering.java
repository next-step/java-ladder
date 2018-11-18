package domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Laddering {

    private static final String ALL_USER = "ALL";

    private List<Player> players;
    private List<Lines> lines;

    public Laddering(List<Player> players, List<Lines> lines) {
        this.players = players;
        this.lines = lines;
    }

    public List<PlayResult> showResult(String playerName, LadderResult ladderResult) {
        if(playerName.equals(ALL_USER))
            return AllPlayerResult(ladderResult);

        return playerResult(new Player(playerName), ladderResult);
    }

    private List<PlayResult> playerResult(Player player, LadderResult ladderResult) {
        List<PlayResult> playResults = new ArrayList<>();
        playResults.add(new PlayResult(player, ladderResult.getResult(getLocation(players.indexOf(player)))));
        return playResults;
    }

    private List<PlayResult> AllPlayerResult(LadderResult ladderResult) {
        List<PlayResult> playResults = new ArrayList<>();
        for(Player player : players){
            playResults.add(new PlayResult(player, ladderResult.getResult(getLocation(players.indexOf(player)))));
        }
        return playResults;
    }

    private int getLocation(int location) {
        int resultLocation = location;
        for (Lines lines : this.lines) {
            resultLocation = getResultLocation(resultLocation, lines);
        }
        return resultLocation;
    }

    private int getResultLocation(int resultLocation, Lines lines) {
        for (Line line : lines.getLine()) {
            resultLocation = line.move(resultLocation);
        }
        return resultLocation;
    }
}
