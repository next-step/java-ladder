package ladder;

import ladder.domain.*;
import ladder.generator.RandomBridgeGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderApplication {

    private static final RandomBridgeGenerator BRIDGE_GENERATOR = new RandomBridgeGenerator();

    public static void main(String[] args) {
        Players players = Players.of(InputView.getPlayerNames());
        Prizes prizes = Prizes.of(InputView.getPrizeNames());
        Height height = new Height(InputView.getLadderHeight());

        Ladder ladder = Ladder.generateLadder(players.count(), height.getHeight(), BRIDGE_GENERATOR);
        OutputView.printGeneratedLadderResult(players, prizes, ladder);

        LadderGame ladderGame = new LadderGame(players, prizes, ladder);
        LadderGameResults gameResults = ladderGame.playGame();

        askPlayerResultUntilAll(gameResults);
    }

    private static void askPlayerResultUntilAll(LadderGameResults gameResults) {
        while (true) {
            String playerName = InputView.getPlayerNameForResult();
            OutputView.printPlayerResult(gameResults, playerName);

            if ("all".equalsIgnoreCase(playerName)) {
                break;
            }
        }
    }
}
