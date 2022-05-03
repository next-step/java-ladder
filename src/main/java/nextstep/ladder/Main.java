package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.OutputView;

public class Main {

    public static void main(String[] args) {
        Participants participants = Participants.createParticipants(InputView.promptNames());
        Prizes prizes = Prizes.createPrizes(InputView.promptPrizes());
        Ladder ladder = Ladder.createLadder(participants.size(), InputView.promptHeight());

        printGameStart(participants, prizes, ladder);

        LadderGameResult result = new LadderGame(participants, ladder).play(prizes);
        OutputView.printResult(result, InputView.promptName());
    }

    private static void printGameStart(Participants participants, Prizes prizes, Ladder ladder) {
        OutputView.printParticipants(participants);
        OutputView.printLines(ladder);
        OutputView.printPrizes(prizes);
    }

}
