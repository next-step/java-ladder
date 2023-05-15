package nextstep.ladder;

import nextstep.ladder.domain.InputView;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.RandomPointGenerator;
import nextstep.ladder.domain.ResultView;
import nextstep.ladder.dto.LadderInput;

public class LadderMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LadderInput ladderInput = inputView.initRadderInformation();
        Ladder ladder = Ladder.of(ladderInput.getUsers(), ladderInput.getHeight(), new RandomPointGenerator(0, ladderInput.getUsersSize() - 1));
        resultView.printLadder(ladder);
    }
}
