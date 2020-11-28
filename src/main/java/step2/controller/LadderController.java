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

        OutputView.printResult();
        Ladder ladder = Ladder.of(new PlayersRewardsDto(players, rewards), new LadderDto(ladderHeight, new RandomLineStrategy()));

        OutputView.printPlayers(players);
        OutputView.printLadder(ladder);
        OutputView.printRewards(rewards);

    }
}
