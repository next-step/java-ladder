package ladder;

import ladder.domain.*;
import ladder.engine.LadderCreator;
import ladder.engine.LadderResult;
import ladder.factory.LadderFactory;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderMain {
    public static void main(String[] args) {
        String playerNames = InputView.inputParticipants();
        String winningPrizes = InputView.inputWinningPrizes();
        int maxLadderHeight = InputView.inputMaxLadderHeight();

        InputView.printStartLineOfLadderGame();

        Players players = new Players(playerNames);
        ResultView.printResultPlayer(players);

        LadderCreator ladderCreator = LadderFactory.create(maxLadderHeight, players.countOfPlayers(), new RandomConnectingStrategy());
        ResultView.printResult(ladderCreator.getLines());

        LadderResult ladderResult = new LadderPrizes(winningPrizes);
        Players result = ladderResult.result(players, ladderCreator);

        for (int i = 0; i < result.countOfPlayers(); i++) {
            String chosen = InputView.inputWhoWantToSeeResult();
            InputView.printResultOfChosenPlayer(getResult(result, chosen));
        }
    }

    private static String getResult(Players result, String chosen) {
        if ("all".equals(chosen)) {
            return ResultView.allPlayerResult(result);
        }
        return result.getPlayers().get(new PlayerName(chosen));
    }
}
