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

        showResult(players, resultMap);
    }

    private static void showResult(Players players, ResultMap resultMap) {
        String targetPlayer = Input.scanPlayerName(players);
        if (targetPlayer.equals("all")) {
            resultMap.getAllAsList()
                    .stream()
                    .forEach(System.out::println);
            return;
        }
        String reward = resultMap.get(targetPlayer);
        Output.print(targetPlayer + ":" + reward + "\n");
        showResult(players, resultMap);
    }

    private static void run(Players players, List<String> rewards, Ladder ladder) {
        // Q: okay to recursive function like this?
        Players targetPlayers = Input.scanPlayerToShow(players);
        List<LadderResult> ladderResults = targetPlayers.results(ladder, rewards);
        Output.printLadderResults(ladderResults);
        if (targetPlayers.size() < players.size()) {
            run(players, rewards, ladder);
        }
    }
}
