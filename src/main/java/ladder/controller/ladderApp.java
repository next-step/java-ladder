package ladder.controller;

import ladder.domain.*;
import ladder.view.Input;
import ladder.view.Output;

import java.util.*;

public class ladderApp {
    public static void main(String[] args) {
        Players players = Input.scanPlayers();
        List<String> rewards = Input.scanRewards();
        Height height = new Height(Input.scanHeight());

        Output.printPlayers(players.players());

        Ladder ladder = new Ladder(height.value(), players.size() - 1);
        Output.printLadder(ladder);
        Output.printRewards(rewards);

        ResultMap resultMap = ladder.results(players.players(), rewards);

        showResultUntilAll(players, resultMap);
    }

    private static void showResultUntilAll(Players players, ResultMap resultMap) {
        String targetPlayer = Input.scanPlayerName(players);
        if (targetPlayer.equals("all")) {
            Output.printResults(resultMap.getAllAsSet());
            return;
        }
        String reward = resultMap.get(targetPlayer);
        Output.printResult(targetPlayer, reward);
        showResultUntilAll(players, resultMap);
    }
}
