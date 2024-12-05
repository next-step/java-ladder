package nextstep.laddergame;

import nextstep.laddergame.domain.*;
import nextstep.laddergame.service.RandomLaddersFactory;
import nextstep.laddergame.view.InputView;
import nextstep.laddergame.view.OutputView;

import java.util.List;

public class LadderGameInterface {
    private static final String ALL_PARTICIPANTS = "all";

    public static void main(String[] args) {
        LadderGameInterface gameInterface = new LadderGameInterface();
        gameInterface.start();
    }

    public void start() {
        List<String> participantsName = InputView.enterParticipantsName();
        LadderGame ladderGame = new LadderGame(participantsName,
                InputView.enterLadderResult(participantsName.size()),
                InputView.enterLadderMaxHeight(),
                new RandomLaddersFactory(),
                new RandomLadderLinesGenerator());

        OutputView.printLadder(ladderGame);

        boolean isAllParticipants = false;
        while (!isAllParticipants) {
            List<String> participantsForResult = InputView.enterParticipantNamesForResult();
            isAllParticipants = isAllParticipants(participantsForResult);

            OutputView.printGameResult(isAllParticipants
                    ? ladderGame.resolveGameResults(participantsName) : ladderGame.resolveGameResults(participantsForResult));
        }
    }

    public boolean isAllParticipants(List<String> names) {
        return names.size() == 1 && ALL_PARTICIPANTS.equals(names.get(0));
    }
}
