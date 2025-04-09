package ladder;

import ladder.domain.*;
import ladder.generator.RandomBridgeGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        Players players = Players.of(InputView.getPlayerNames());
        Prizes prizes = Prizes.of(InputView.getPrizeNames());
        Height height = new Height(InputView.getLadderHeight());

        Ladder ladder = Ladder.generateLadder(players.count(), height.getHeight(), new RandomBridgeGenerator());
        OutputView.printGeneratedLadderResult(players, prizes, ladder);

        LadderGame ladderGame = new LadderGame(players, prizes, ladder);
        LadderGameResult gameResult = ladderGame.playGame();

        askPlayerResultUntilAll(gameResult);
    }

    private static void askPlayerResultUntilAll(LadderGameResult gameResult) {
        while (true) {
            String playerName = InputView.getPlayerNameForResult();
            OutputView.printPlayerResult(gameResult, playerName);

            if ("all".equalsIgnoreCase(playerName)) {
                break;
            }
        }
    }
}
