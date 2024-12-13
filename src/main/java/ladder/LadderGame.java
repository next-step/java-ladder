package ladder;


import ladder.domain.LadderResult;
import ladder.domain.MatchingResult;
import ladder.domain.Players;
import ladder.domain.engine.Ladder;
import ladder.domain.engine.Rewards;
import ladder.domain.factory.LadderFactory;
import ladder.io.InputHandler;
import ladder.io.OutputHandler;

public class LadderGame {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public LadderGame(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        Players players = inputHandler.createPlayers();
        Rewards rewards = inputHandler.createRewards();
        Ladder ladder = LadderFactory.createLadder(inputHandler.getHeightOfLadderFromUser(), players.size());

        outputHandler.showLadderGameResult(players, ladder, rewards);

        MatchingResult matchingResult = ladder.play();
        LadderResult result = matchingResult.map(players, rewards);

        outputHandler.printResult(result);
    }
}
