package nextstep.ladder.view;

import nextstep.ladder.Ladder;
import nextstep.ladder.LadderInput;
import nextstep.ladder.participant.Participants;
import nextstep.ladder.RandomLadderPoint;

import java.util.Scanner;

public class LadderApp {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        startApp();
    }

    private static void startApp() {

        String[] names = InputView.inputName(scanner);
        int depth = InputView.makeDepth(scanner);
        Participants participants = Participants.of(names);
        LadderInput input = new LadderInput(participants, depth);

        input.setRandomPoint(new RandomLadderPoint());

        Ladder ladder = Ladder.of(input);

        OutputView.showResult(ladder);
    }

}
