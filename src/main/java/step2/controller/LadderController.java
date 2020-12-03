package step2.controller;

import step2.domain.*;
import step2.hint.LadderPointGenerator;
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
        Ladder ladder = Ladder.of(ladderHeight, players.getPlayersCount(), new RandomLadderPointGenerator());

        OutputView.printPlayers(players);
        OutputView.printLadder(ladder);
        OutputView.printRewards(rewards);

        printResult(LadderGame.runGame(players, rewards, ladder));

    }

    private static void printResult(PlayerRewardMatches playerRewardMatches) {
        while (true) {
            String player = InputView.putWantPrintPlay();
            if (isAllPrint(player)) {
                printAllPlayer(playerRewardMatches);
                continue;
            }
            if (gameEnd(player)) return;

            printPlayer(playerRewardMatches, player);
        }
    }

    private static boolean isAllPrint(String player) {
        return player.equals(ALL);
    }

    private static boolean gameEnd(String player) {
        return player.equals(END);
    }

    private static void printPlayer(PlayerRewardMatches playerRewardMatches, String player) {
        OutputView.printPlayerReward(playerRewardMatches, player);
    }

    private static void printAllPlayer(PlayerRewardMatches playerRewardMatches) {
        OutputView.printAllPlayerReward(playerRewardMatches);
    }


}
