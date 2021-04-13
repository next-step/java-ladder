package ladder.domain.nextstep;

import ladder.domain.engine.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class NextStepLadder implements Ladder {
    private final List<Line> lines;
    protected NextStepLadder(List<Line> lines) {
        this.lines = lines;
    }

    private void initPlayersPosition(Players players, HashMap<Player, Integer> playersPosition){
        List<Player> playersList = players.players();
        for(int i = 0; i < playersList.size(); i++){
            playersPosition.put(playersList.get(i), i);
        }
    }

    private void movePlayersPosition(HashMap<Player, Integer> playersPosition){
        List<Line> lines = this.lines;
        for(int i = 0; i < lines.size(); i++){
            move(lines.get(i), playersPosition);
        }
    }

    private void move(Line line, HashMap<Player, Integer> playersPosition){
        for(Player player : playersPosition.keySet()){
            int position = playersPosition.get(player);
            playersPosition.put(player,line.move(position));
        }
    }

    private HashMap<Player, String> playersResults(HashMap<Player, Integer> playersPosition, ExecutionResults executionResults){
        HashMap<Player, String> playersResults = new HashMap<>();
        List<String> executionResultsList = executionResults.executionResults();
        for(Player player : playersPosition.keySet()) {
            playersResults.put(player, executionResultsList.get(playersPosition.get(player)));
        }
        return playersResults;
    }

    public List<Line> lines(){
        return Collections.unmodifiableList(lines);
    }

    @Override
    public LadderResults ladderResults(Players players, ExecutionResults executionResults){
        HashMap<Player, Integer> playersPosition = new HashMap<>();
        initPlayersPosition(players,playersPosition);
        movePlayersPosition(playersPosition);
        return new LadderResults(playersResults(playersPosition, executionResults));
    }
}
