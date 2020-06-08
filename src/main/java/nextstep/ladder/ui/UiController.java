package nextstep.ladder.ui;

import nextstep.ladder.domain.game.LadderGame;
import nextstep.ladder.domain.gameresult.GameResults;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.PointAddStrategy;
import nextstep.ladder.domain.ladder.RandomPointAddStrategy;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.reward.Rewards;

import java.util.Scanner;

public class UiController {
    private static final Scanner LADDER_GAME_SCANNER = new Scanner(System.in);
    private static final PointAddStrategy RANDOM_POINT_ADD_STRATEGY = new RandomPointAddStrategy();

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

        LadderGame ladderGame = LadderGame.readyLadderGame(players, ladder);
        initGameResult(ladderGame.playGame(rewards));

        printGameStatus(players);
        gameResultsInputView.startPrintGameResult(LADDER_GAME_SCANNER);
    }

    private static void initLadderGame() {
        playerInputView = PlayerInputView.createByUserInput(LADDER_GAME_SCANNER);
        rewardInputView = RewardInputView.createByUserInput(LADDER_GAME_SCANNER);
        ladderHeightInputView = LadderHeightInputView.createByUserInput(LADDER_GAME_SCANNER);
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
