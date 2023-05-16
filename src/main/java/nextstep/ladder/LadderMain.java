package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.dto.LadderInput;
import nextstep.ladder.dto.ResultInput;

public class LadderMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LadderInput ladderInput = inputView.initRadderInformation();
        Ladder ladder = Ladder.of(ladderInput.getUsers(), ladderInput.getHeight(), new RandomPointGenerator(0, ladderInput.getUsersSize() - 1), new LadderResults(ladderInput.getResults()));
        ResultView resultView = new ResultView(ladder);
        resultView.printLadder();
        ladder.play();
        while (true) {
            ResultInput resultInput = inputView.initResultInput();
            resultView.printResult(resultInput.getName(), resultInput.isAll());
        }
    }
}
