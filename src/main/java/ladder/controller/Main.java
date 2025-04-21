package ladder.controller;

import ladder.model.Ladder;
import ladder.model.LadderResult;
import ladder.model.LadderSession;
import ladder.model.LadderSlots;
import ladder.model.LadderSlotsPair;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {

    public static void main(String[] args) {
        String userNames = InputView.getUserNames();
        String resultNames = InputView.getResults();
        LadderSlotsPair ladderSlotsPair = new LadderSlotsPair(userNames, resultNames);

        int height = InputView.getHeight();
        Ladder ladder = new Ladder(ladderSlotsPair.size(), height);

        LadderSession session = new LadderSession(ladderSlotsPair, ladder);
        OutputView.printLadderSession(session);

        LadderResult ladderResult = session.runGame();

        gameLoop(ladderResult);
    }

    private static void gameLoop(LadderResult ladderResult) {
        while(true) {
            String target = InputView.getTarget();

            if (ladderResult.hasUserName(target)) {
                String result = ladderResult.getGameResult(target);
                OutputView.printGameResult(result);
                continue;
            }

            break;
        }

    }
}
