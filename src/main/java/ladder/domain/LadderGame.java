package ladder.domain;

import static ladder.ui.Blank.printBlank;
import static ladder.ui.InputView.heightInput;
import static ladder.ui.InputView.participantInput;
import static ladder.ui.OutputView.printLine;
import static ladder.ui.OutputView.printParticipants;
import static ladder.ui.OutputView.resultBanner;

import ladder.ui.OutputView;
import ladder.util.RandomPointStrategy;

public class LadderGame {

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {

        Participants participants = participantInput().participants();

        printBlank();

        Lines lines = heightInput().linesByHeight(participants.countOfPerson(),
                new RandomPointStrategy());

        resultBanner();

        printBlank();

        printParticipants(participants);

        lines.immutableGet().forEach(OutputView::printLine);
    }

}
