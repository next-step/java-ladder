package ladder.domain.nextstep;

import ladder.domain.engine.Ladder;
import ladder.domain.engine.LadderResults;

import java.util.HashMap;
import java.util.List;

public class NextStepLadder {
    private static final int MIN_HEIGHT = 1;
    private static final String MESSAGE_MIN_HEIGHT = "사다리 높이는 1이상이어야 합니다.";
    private final Lines lines = new Lines();
    private final int height;

    public NextStepLadder(int numberOfPlayers, int height) {
        validate(height);
        this.height = height;
        generateLadder(numberOfPlayers, height);
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(MESSAGE_MIN_HEIGHT);
        }
    }

    private void initPlayersPosition(Players players, HashMap<Player, Integer> playersPosition){
        List<Player> playersList = players.players();
        for(int i = 0; i < playersList.size(); i++){
            playersPosition.put(playersList.get(i), i);
        }
    }

    private void movePlayersPosition(HashMap<Player, Integer> playersPosition){
        List<NextStepLine> lines = this.lines.lines();
        for(int i = 0; i < lines.size(); i++){
            move(lines.get(i).points(), playersPosition);
        }
    }

    private void move(List<Point> points, HashMap<Player, Integer> playersPosition){
        for(Player player : playersPosition.keySet()){
            int position = playersPosition.get(player);
            position += points.get(position).move();
            playersPosition.put(player,position);
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

    public void generateLadder(int numberOfPlayers, int height) {
        for(int i=0; i<height; i++){
            lines.add(new NextStepLine(numberOfPlayers));
        }
    }

    public List<NextStepLine> lines(){
        return lines.lines();
    }

    public LadderResults ladderResults(Players players, ExecutionResults executionResults){
        HashMap<Player, Integer> playersPosition = new HashMap<>();
        initPlayersPosition(players,playersPosition);
        movePlayersPosition(playersPosition);
        return new LadderResults(playersResults(playersPosition, executionResults));
    }
}
