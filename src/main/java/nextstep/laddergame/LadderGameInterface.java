package nextstep.laddergame;

import nextstep.laddergame.domain.*;
import nextstep.laddergame.service.LadderGameService;
import nextstep.laddergame.service.RandomLaddersFactory;
import nextstep.laddergame.view.InputView;
import nextstep.laddergame.view.OutputView;

import java.util.List;

public class LadderGameInterface {
    private static final String ALL_PARTICIPANTS = "all";

    private final LadderGameService ladderGameService;

    public LadderGameInterface(LadderGameService ladderGameService) {
        this.ladderGameService = ladderGameService;
    }

    public static void main(String[] args) {
        LadderGameInterface gameInterface = new LadderGameInterface(new LadderGameService());
        gameInterface.start();
    }

    public void start() {
        List<String> participantsName = InputView.enterParticipantsName();
        LadderGame ladderGame = ladderGameService.createLadder(
                participantsName,
                InputView.enterLadderResult(participantsName.size()),
                InputView.enterLadderMaxHeight(),
                new RandomLaddersFactory(),
                new RandomLadderLinesGenerator());

        OutputView.printLadder(ladderGame);

        String participantsForResult = "";
        while (!ALL_PARTICIPANTS.equals(participantsForResult)) {
            participantsForResult = InputView.enterParticipantNamesForResult();
            OutputView.printGameResult(ladderGameService.resolveGameResults(ladderGame, participantsForResult));
        }
    }

}
