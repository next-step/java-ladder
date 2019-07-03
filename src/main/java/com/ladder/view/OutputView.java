package com.ladder.view;

import com.ladder.model.LadderGame;
import com.ladder.model.PlayReport;
import com.ladder.model.Players;
import com.ladder.model.Rewards;
import com.ladder.view.formatter.Formatter;

import java.util.Map;

public class OutputView {

    public static final String ALL_SEARCH_KEYWORD = "all";
    private static final String PRINT_MESSAGE_OF_RESULT = "실행 결과";
    private final Formatter<Players> userNamesFormatter;
    private final Formatter<LadderGame> ladderFormatter;
    private Formatter<Rewards> rewardsFormatter;

    public OutputView(Formatter<Players> userNamesFormatter,
                      Formatter<LadderGame> ladderFormatter,
                      Formatter<Rewards> rewardsFormatter) {
        this.userNamesFormatter = userNamesFormatter;
        this.ladderFormatter = ladderFormatter;
        this.rewardsFormatter = rewardsFormatter;
    }

    public void printUserName(Players players) {
        System.out.println(userNamesFormatter.format(players));
    }

    public void printLadder(LadderGame ladderGame) {
        System.out.print(ladderFormatter.format(ladderGame));
    }

    public void printReward(Rewards rewards) {
        System.out.println(rewardsFormatter.format(rewards));
    }

    public void printResult(String searchPlayerName, PlayReport playReport) {
        if (ALL_SEARCH_KEYWORD.equals(searchPlayerName)){
            printResultOfAll(playReport.searchByAll());
            return;
        }
        printResultOfSingle(playReport.searchByName(searchPlayerName));
    }

    private void printResultOfSingle(String rewardName) {
        System.out.println(PRINT_MESSAGE_OF_RESULT);
        System.out.println(rewardName);
    }

    private void printResultOfAll(Map<String, String> results) {
        System.out.println(PRINT_MESSAGE_OF_RESULT);
        results.entrySet().stream()
                .forEach(resultEachOfPlayer ->
                        System.out.println(
                                resultEachOfPlayer.getKey() + " : " +
                                resultEachOfPlayer.getValue()
                        )
                );
    }
}
