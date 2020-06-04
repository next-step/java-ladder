package nextstep.ladder.ui;

import nextstep.ladder.application.LadderGameService;
import nextstep.ladder.domain.*;

import java.util.Scanner;

public class UiController {
    private static final Scanner GAME_INIT_SCANNER = new Scanner(System.in);
    private static final Scanner GAME_RESULT_SCANNER = new Scanner(System.in);
    private static final PointAddStrategy RANDOM_POINT_ADD_STRATEGY = new RandomPointAddStrategy();
    private static final LadderGameService ladderGameService = new LadderGameService();

    private static PlayerInputView playerInputView;
    private static RewardInputView rewardInputView;
    private static LadderHeightInputView ladderHeightInputView;
    private static LadderOutputView ladderOutputView;
    private static RewardsOutputView rewardsOutputView;
    private static GameResultsOutputView gameResultsOutputView;
    private static GameResultsInputView gameResultsInputView;

    public static void main(String[] args) {
        initLadderGame();

        Ladder ladder = Ladder.create(ladderHeightInputView.getMaxLadderHeight(),
                playerInputView.getPlayerSize(), RANDOM_POINT_ADD_STRATEGY);
        Players players = playerInputView.getPlayers();
        Rewards rewards = rewardInputView.getRewards();
        initGameStatusOutput(ladder, players, rewards);

        GameResults gameResults = ladderGameService.playGame(players, ladder, rewards);
        initGameResult(gameResults);

        printGameStatus(players);
        gameResultsInputView.startPrintGameResult(GAME_RESULT_SCANNER);
    }

    private static void initLadderGame() {
        playerInputView = PlayerInputView.createByUserInput(GAME_INIT_SCANNER);
        rewardInputView = RewardInputView.createByUserInput(GAME_INIT_SCANNER);
        ladderHeightInputView = LadderHeightInputView.createByUserInput(GAME_INIT_SCANNER);
    }

    private static void initGameStatusOutput(Ladder ladder, Players players, Rewards rewards) {
        ladderOutputView = new LadderOutputView(players, ladder);
        rewardsOutputView = new RewardsOutputView(rewards);
    }

    private static void initGameResult(GameResults gameResults) {
        gameResultsOutputView = new GameResultsOutputView(gameResults);
        gameResultsInputView = new GameResultsInputView(gameResultsOutputView);
    }

    private static void printGameStatus(Players players) {
        System.out.println(ladderOutputView.parsePlayerNames());
        System.out.println(ladderOutputView.parseLadder());
        System.out.println(rewardsOutputView.parseRewards(players.getMaxNameLength()));
    }
}
