package step2.controller;

import step2.domain.*;
import step2.dto.LadderDto;
import step2.dto.PlayersRewardsDto;
import step2.view.InputView;
import step2.view.OutputView;


public class LadderController {

    private LadderController() {}

    public static void runLadder() {
        Players players = Players.of(NameSplitter.splitParticipationNames(InputView.putParticipation()));
        Rewards rewards = Rewards.of(NameSplitter.splitParticipationNames(InputView.putReward()));
        int ladderHeight = InputView.putLadderHeight();

        OutputView.printLadderResult();
        PlayersRewardsDto playersRewardsDto = new PlayersRewardsDto(players, rewards);
        Ladder ladder = Ladder.of(playersRewardsDto, new LadderDto(ladderHeight, new RandomLineStrategy()));

        OutputView.printPlayers(players);
        OutputView.printLadder(ladder);
        OutputView.printRewards(rewards);



        printResult( LadderGame.runGame(ladder, playersRewardsDto));
    }

    private static void printResult(LadderGameResult ladderGameResult) {
        while (true) {
            String player = InputView.putWantPrintPlay();
            if (isAllPrint(player)) {
                printAllPlayer(ladderGameResult);
                continue;
            }
            if (gameEnd(player)) return;

            printPlayer(ladderGameResult, player);
        }
    }

    private static boolean isAllPrint(String player) {
        return player.equals("all");
    }
    private static boolean gameEnd(String player) {
        return player.equals("end");
    }

    private static void printPlayer(LadderGameResult ladderGameResult, String player) {
        OutputView.printPlayerReward(ladderGameResult, player);
    }

    private static void printAllPlayer(LadderGameResult ladderGameResult) {
        OutputView.printAllPlayerReward(ladderGameResult);
    }


}
