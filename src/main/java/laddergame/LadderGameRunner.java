package laddergame;

import java.util.List;
import java.util.Scanner;
import laddergame.domain.ladder.Depth;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderGame;
import laddergame.domain.line.Connection;
import laddergame.domain.line.Line;
import laddergame.domain.person.Participants;
import laddergame.domain.results.Match;
import laddergame.domain.results.ResultMatcher;
import laddergame.domain.results.Results;
import laddergame.utils.CommaSplit;
import laddergame.view.InputView;
import laddergame.view.LadderView;
import laddergame.view.ResultView;

public class LadderGameRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView();

        Participants participants = Participants.of(getNames(scanner, inputView));

        Results results = Results.of(getExecutionResult(scanner, inputView));

        var count = getCount(scanner, inputView);
        var lines = Line.list(Depth.of(count), participants, new Connection());
        var ladder = Ladder.of(lines,new Match());
        var ladderGame = LadderGame.create(ladder, participants);

        LadderView ladderView = new LadderView(ladderGame, results);
        ladderView.printLadder();

        ResultMatcher resultMatcher = new ResultMatcher(ladderGame, results);
        ResultView resultView = new ResultView(resultMatcher);

        resultView.printResult(getTarget(scanner, resultView));
    }

    private static String getTarget(final Scanner scanner, final ResultView resultView) {
        resultView.printTargetResult();
        return scanner.next();
    }

    private static String[] getExecutionResult(final Scanner scanner, final InputView inputView) {
        inputView.printExecutionResult();
        String executionResults = scanner.next();
        return CommaSplit.of(executionResults);
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
