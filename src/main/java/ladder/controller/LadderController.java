package ladder.controller;

import ladder.domain.ladder.ladder.Ladder;
import ladder.domain.ladder.ladder.LadderDecorator;
import ladder.domain.ladder.ladder.LadderGenerator;
import ladder.domain.player.PlayerNames;
import ladder.domain.prize.LadderPrizes;
import ladder.dto.LadderResult;
import ladder.factory.LadderFactoryBean;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private final LadderDecorator ladderDecorator;
    private final Ladder ladder;

    private LadderController(LadderDecorator ladderDecorator, Ladder ladder) {
        this.ladderDecorator = ladderDecorator;
        this.ladder = ladder;
    }

    public static LadderController create() {
        // player names and prizes
        PlayerNames playerNames = PlayerNames.of(InputView.playerNames());
        LadderPrizes ladderPrizes = LadderPrizes.of(InputView.prizes());
        LadderDecorator ladderDecorator = LadderDecorator.of(playerNames, ladderPrizes);

        // generate ladder
        int countOfPeople = playerNames.size();
        int ladderHeight = InputView.ladderHeight();
        LadderGenerator ladderGenerator = LadderFactoryBean.ladderGenerator();
        Ladder ladder = ladderGenerator.generate(ladderHeight, countOfPeople);

        return new LadderController(ladderDecorator, ladder);
    }

    public void run() {
        // print ladder
        ResultView.printDecoratedLadder(ladder, ladderDecorator);

        // execute ladder map[name -> prize]
        LadderResult ladderResult = ladder.permute();

        // process ladder result query
        String query;
        while (!(query = InputView.resultForName()).isEmpty()) {
            handleQuery(query, ladderResult);
        }
    }

    private void handleQuery(String query, LadderResult ladderResult) {
        if ("all".equals(query)) {
            ResultView.printAllResult(ladderResult, ladderDecorator);
            return;
        }
        PlayerNames playerNames = ladderDecorator.getPlayerNames();
        LadderPrizes ladderPrizes = ladderDecorator.getLadderPrizes();
        int index = playerNames.getIndexByName(query);
        int resultIndex = ladderResult.resultByIndex(index);
        ResultView.printLadderResult(resultIndex, ladderPrizes);
    }
}
