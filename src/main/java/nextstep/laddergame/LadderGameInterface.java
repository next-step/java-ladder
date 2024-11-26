package nextstep.laddergame;

import nextstep.laddergame.domain.RandomLadderLinesGenerator;
import nextstep.laddergame.service.LadderGameService;
import nextstep.laddergame.service.RandomLaddersFactory;
import nextstep.laddergame.view.InputView;
import nextstep.laddergame.view.OutputView;

public class LadderGameInterface {
    private final LadderGameService ladderGameService;

    public LadderGameInterface(LadderGameService ladderGameService) {
        this.ladderGameService = ladderGameService;
    }

    public static void main(String[] args) {
        LadderGameInterface gameInterface = new LadderGameInterface(new LadderGameService());
        gameInterface.start();
    }

    public void start() {
        OutputView.printGameResult(ladderGameService.start(
                InputView.enterParticipantsName(),
                InputView.enterLadderMaxHeight(),
                new RandomLaddersFactory(),
                new RandomLadderLinesGenerator()));
    }

}
