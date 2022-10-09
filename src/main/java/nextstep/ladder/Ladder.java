package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Ladder {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] participants = inputView.inputParticipants();
        String[] ladderResults = inputView.inputLadderResults();
        int ladderHeight = inputView.inputLadderHeight();

        LadderGame ladderGame = new LadderGame(participants, ladderResults, ladderHeight);

        ResultView resultView = new ResultView();
        resultView.printLadderGame(ladderGame);

        String name = inputView.inputParticipant();
        resultView.printResultByName(ladderGame, name);
    }
}
