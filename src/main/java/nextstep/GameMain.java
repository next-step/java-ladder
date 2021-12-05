package nextstep;

import nextstep.ladder.Ladder;
import nextstep.ladder.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class GameMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Participants participants = inputView.inputJoinParticipants();

        int ladderHeight = inputView.inputLadderHeight();
        Ladder ladder = new Ladder(ladderHeight, participants.size());

        OutputView outputView = new OutputView();
        outputView.printResult(participants, ladder);
    }
}
