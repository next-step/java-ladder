package nextstep.ladder.view;

import nextstep.ladder.Ladder;
import nextstep.ladder.LadderInput;
import nextstep.ladder.RandomLadderPoint;

import java.util.Scanner;

public class LadderApp {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        startApp();
    }

    private static void startApp() {

        LadderInput input = InputView.showInputView(scanner);

        input.setRandomPoint(new RandomLadderPoint());

        Ladder ladder = Ladder.of(input);

        OutputView.showResult(ladder);
    }



}
