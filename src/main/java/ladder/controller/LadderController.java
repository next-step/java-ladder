package ladder.controller;

import java.util.Map;
import ladder.domain.engine.Ladder;
import ladder.domain.engine.LadderCreator;
import ladder.domain.player.PlayerNames;
import ladder.domain.prize.LadderPrizes;
import ladder.dto.LadderResult;
import ladder.dto.LadderResultProcessor;
import ladder.exception.InvalidQueryException;
import ladder.factory.LadderFactoryBean;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private final PlayerNames playerNames;
    private final LadderPrizes ladderPrizes;

    private LadderController(PlayerNames playerNames, LadderPrizes ladderPrizes) {
        this.playerNames = playerNames;
        this.ladderPrizes = ladderPrizes;
    }

    public static LadderController create() {
        PlayerNames playerNames = PlayerNames.of(InputView.playerNames());
        LadderPrizes ladderPrizes = LadderPrizes.of(InputView.prizes());
        return new LadderController(playerNames, ladderPrizes);
    }

    public void run() {
        Ladder ladder = ladderFromInput();
        Map<String, String> nameToPrize = executeLadder(ladder);
        printNamesLadderPrizes(ladder);
        queryProcessLoop(nameToPrize);
    }

    private void queryProcessLoop(Map<String, String> nameToPrize) {
        String query;
        while (!(query = InputView.resultForName()).isEmpty()) {
            handleQuery(query, nameToPrize);
        }
    }

    private void printNamesLadderPrizes(Ladder ladder) {
//        int maxLength = ResultView.findMaxLength(playerNames, ladderPrizes);
//        ResultView.printHeader();
//        ResultView.printPlayerNames(playerNames, maxLength);
//        ResultView.printLadder(ladder, maxLength);
//        ResultView.printLadderPrizes(ladderPrizes, maxLength);
    }

    private Map<String, String> executeLadder(Ladder ladder) {
        LadderResult ladderResult = ladder.permute();
        LadderResultProcessor ladderResultProcessor =
                LadderResultProcessor.of(playerNames, ladderPrizes);
        return ladderResultProcessor.process(ladderResult);
    }

    private Ladder ladderFromInput() {
        int countOfPeople = playerNames.size();
        int ladderHeight = InputView.ladderHeight();
        LadderCreator ladderCreator = LadderFactoryBean.ladderCreator();
        return ladderCreator.create(countOfPeople, ladderHeight);
    }

    private void handleQuery(String query, Map<String, String> nameToPrize) {
        if ("all".equals(query)) {
            ResultView.printAllResults(nameToPrize);
            return;
        }
        if (!nameToPrize.containsKey(query)) {
            throw new InvalidQueryException();
        }
        ResultView.printResultByName(query, nameToPrize);
    }
}
