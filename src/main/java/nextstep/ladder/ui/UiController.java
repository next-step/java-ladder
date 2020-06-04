package nextstep.ladder.ui;

import nextstep.ladder.application.LadderGameService;
import nextstep.ladder.domain.*;

import java.util.Scanner;

public class UiController {
    public static void main(String[] args) {
        Scanner playerInputScanner = new Scanner(System.in);
        PlayerInputView playerInputView = PlayerInputView.createByUserInput(playerInputScanner);

        Scanner rewardInputScanner = new Scanner(System.in);
        RewardInputView rewardInputView = RewardInputView
                .createByUserInput(rewardInputScanner);

        Scanner maxLadderHeightInputScanner = new Scanner(System.in);
        LadderHeightInputView ladderHeightInputView = LadderHeightInputView
                .createByUserInput(maxLadderHeightInputScanner);

        PointAddStrategy pointAddStrategy = new RandomPointAddStrategy();
        Ladder ladder = Ladder.create(ladderHeightInputView.getMaxLadderHeight(),
                playerInputView.getPlayerSize(), pointAddStrategy);
        Players players = playerInputView.getPlayers();
        Rewards rewards = rewardInputView.getRewards();

        LadderOutputView ladderOutputView = new LadderOutputView(players, ladder);
        RewardsOutputView rewardsOutputView = new RewardsOutputView(rewards);

        LadderGameService ladderGameService = new LadderGameService();
        GameResults gameResults = ladderGameService.playGame(players, ladder, rewards);

        GameResultsOutputView gameResultsOutputView = new GameResultsOutputView(gameResults);
        GameResultsInputView gameResultsInputView = new GameResultsInputView(gameResultsOutputView);

        System.out.println(ladderOutputView.parsePlayerNames());
        System.out.println(ladderOutputView.parseLadder());
        System.out.println(rewardsOutputView.parseRewards(players.getMaxNameLength()));
        Scanner gameResultsInputScanner = new Scanner(System.in);
        gameResultsInputView.startGameResult(gameResultsInputScanner);
    }
}
