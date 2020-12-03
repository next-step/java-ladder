package step2.controller;

import step2.domain.*;
import step2.hint.RandomLadderPointGenerator;
import step2.view.InputView;
import step2.view.OutputView;


public class LadderController {

    public static final String ALL = "all";
    public static final String END = "end";

    private LadderController() {}

    public static void runLadder() {
        Players players = Players.of(NameSplitter.splitParticipationNames(InputView.putParticipation()));
        Rewards rewards = Rewards.of(NameSplitter.splitParticipationNames(InputView.putReward()));
        int ladderHeight = InputView.putLadderHeight();

        OutputView.printLadderResult();
        Ladder ladder = new Ladder.LadderBuilder()
                .buildLadderHeight(ladderHeight)
                .buildPlayerCount(players.getPlayersCount())
                .buildLadderPointGenerator(new RandomLadderPointGenerator())
                .build();

        OutputView.printPlayers(players);
        OutputView.printLadder(ladder);
        OutputView.printRewards(rewards);

        printResult(LadderGame.runGame(players, rewards, ladder));

    }

    private static void printResult(GameResults gameResults) {
        while (true) {
            String player = InputView.putWantPrintPlay();
            if (isAllPrint(player)) {
                printAllPlayer(gameResults);
                continue;
            }
            if (gameEnd(player)) return;

            printPlayer(gameResults, player);
        }
    }

    private static boolean isAllPrint(String player) {
        return player.equals(ALL);
    }

    private static boolean gameEnd(String player) {
        return player.equals(END);
    }

    private static void printPlayer(GameResults gameResults, String player) {
        OutputView.printPlayerReward(gameResults, player);
    }

    private static void printAllPlayer(GameResults gameResults) {
        OutputView.printAllPlayerReward(gameResults);
    }


}
