package nextstep.ladder;

import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        String[] names = InputView.inputName();
        Participant participant = new Participant(names);
        String[] result = InputView.inputResult();
        LadderResult ladderResult = new LadderResult(result);
        int height = InputView.inputHeight();
        Ladder ladder = new Ladder(height, participant.getParticipantSize(), new RandomLineStrategy());


        LadderGame ladderGame = new LadderGame(ladder, participant, ladderResult);

        OutputView.showLadder(ladderGame);
        OutputView.showResult(ladderGame);
    }
}
