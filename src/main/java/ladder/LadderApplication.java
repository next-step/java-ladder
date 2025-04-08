package ladder;

import ladder.domain.*;
import ladder.generator.RandomBridgeGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Map;

public class LadderApplication {
    public static void main(String[] args) {
        Players players = Players.of(InputView.getPlayerNames());
        Prizes prizes = Prizes.of(InputView.getPrizeNames());
        Height ladderHeight = new Height(InputView.getLadderHeight());

        Ladder ladder = Ladder.generateLadder(players.getPlayerCount(), ladderHeight.getHeight(), new RandomBridgeGenerator());
        OutputView.printGeneratedLadderResult(players, prizes, ladder);

        LadderGame ladderGame = new LadderGame(players, prizes, ladder);
        LadderGameResult gameResult = ladderGame.playGame();

        askPlayerResultUntilAll(gameResult);
    }

    private static void askPlayerResultUntilAll(LadderGameResult gameResult) {
        while (true) {
            String targetName = InputView.getResultTargetName();
            OutputView.printPlayerResult(gameResult, targetName);

            if ("all".equalsIgnoreCase(targetName)) {
                break;
            }
        }
    }
}
