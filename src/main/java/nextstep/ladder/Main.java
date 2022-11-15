package nextstep.ladder;

import java.util.Scanner;

import nextstep.ladder.view.InputSupplier;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputConsumer;
import nextstep.ladder.view.ResultView;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final InputSupplier inputSupplier = scanner::nextLine;
        final OutputConsumer outputConsumer = System.out::println;

        final InputView inputView = new InputView(inputSupplier, outputConsumer);
        final ResultView resultView = new ResultView(outputConsumer);

        final LadderGame ladderGame = new LadderGame(inputView, resultView);
        ladderGame.printLadder();
    }

}
