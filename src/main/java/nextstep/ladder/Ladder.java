package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Ladder {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] participants = inputView.inputParticipants();
        int ladderHeight = inputView.inputLadderHeight();

        LadderGame ladderGame = new LadderGame(participants, ladderHeight);

        ResultView resultView = new ResultView();
        resultView.printResult(ladderGame.ladderInfo(), ladderGame.participants());
    }
}
