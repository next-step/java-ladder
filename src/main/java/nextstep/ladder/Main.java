package nextstep.ladder;

import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        String[] names = InputView.inputName();
        Participant participant = new Participant(names);
        int height = InputView.inputHeight();
        Ladder ladder = new Ladder(height, participant, new RandomLineStrategy());

        OutputView.showLadder(ladder);
    }
}
