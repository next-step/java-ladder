package laddergame;

import java.util.Scanner;
import laddergame.domain.ladder.Depth;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderGame;
import laddergame.domain.line.Connection;
import laddergame.domain.person.Participants;
import laddergame.utils.CommaSplit;
import laddergame.view.InputView;
import laddergame.view.ResultView;

public class LadderGameRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView();

        var names = getNames(scanner, inputView);
        var participants = new Participants(names);
        var count = getCount(scanner, inputView);
        var ladder = Ladder.of(new Connection(), Depth.of(count), participants);
        var ladderGame = LadderGame.create(ladder, participants);

        ResultView resultView = new ResultView(ladderGame);
        resultView.printResult();
    }

    private static int getCount(final Scanner scanner, final InputView inputView) {
        inputView.printDepthComment();
        return scanner.nextInt();
    }

    private static String[] getNames(final Scanner scanner, final InputView inputView) {
        inputView.printNameComment();
        String names = scanner.next();
        return CommaSplit.of(names);
    }
}
