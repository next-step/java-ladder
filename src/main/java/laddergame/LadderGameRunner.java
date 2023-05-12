package laddergame;

import java.util.Scanner;
import laddergame.domain.Depth;
import laddergame.domain.Ladder;
import laddergame.domain.LadderGame;
import laddergame.domain.LineStrategyImpl;
import laddergame.domain.Participants;
import laddergame.utils.Split;
import laddergame.view.InputView;
import laddergame.view.ResultView;

public class LadderGameRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView();

        String names = getNames(scanner, inputView);
        Participants participants = new Participants(Split.of(names));
        int count = getCount(scanner, inputView);

        Ladder ladder = Ladder.of(new LineStrategyImpl(), new Depth(count), participants);
        LadderGame ladderGame = LadderGame.create(ladder, participants);

        ResultView resultView = new ResultView(ladderGame);
        resultView.printResult();
    }

    private static int getCount(final Scanner scanner, final InputView inputView) {
        inputView.printDepthComment();
        return scanner.nextInt();
    }

    private static String getNames(final Scanner scanner, final InputView inputView) {
        inputView.printNameComment();
        return scanner.next();
    }
}
