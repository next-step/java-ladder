package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderController {

    private Players players;
    private ExecutionResults executionResults;
    private Ladder ladder;
    private LadderStatistics ladderStatistics;

    public LadderController(){
        players = new Players(InputView.enterPlayers());
        executionResults = new ExecutionResults(players.numberOfPlayer(), InputView.enterExecutionResults());
        ladder = new Ladder(players.numberOfPlayer(), InputView.enterHeight());
    }

    private void printPlayers(){
        List<String> playersList = players.players()
                                        .stream()
                                        .map(player -> player.name())
                                        .collect(Collectors.toList());
        ResultView.printPlayers(playersList);
    }

    private void printExecutionResult(){
        Map<Player, String> resultsPlayer = ladderStatistics.results(new Player(InputView.enterPlayerYouWant()));
        HashMap<String, String> resultsString = new HashMap<>();
        for(Player player : resultsPlayer.keySet()){
            resultsString.put(player.name(),resultsPlayer.get(player));
        }
        ResultView.printExecutionResult(resultsString);
    }

    public void run(){
        printPlayers();
        ResultView.printLadder(ladder);
        ResultView.printResult(executionResults);

        ladderStatistics = ladder.ladderStatistics(players, executionResults);
        printExecutionResult();
        printExecutionResult();
    }

}
