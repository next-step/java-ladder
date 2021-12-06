package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.PositiveNumber;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class GameMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Participants participants = inputView.inputJoinParticipants();

        PositiveNumber ladderHeight = inputView.inputLadderHeight();
        Ladder ladder = Ladder.create(ladderHeight, participants.size());

        OutputView outputView = new OutputView();
        outputView.printResult(participants, ladder);
    }
}
