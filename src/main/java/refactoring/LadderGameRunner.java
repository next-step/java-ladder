package refactoring;

import java.util.Scanner;
import refactoring.domain.Ladder;
import refactoring.domain.LadderFatory;
import refactoring.domain.LineFactory;
import refactoring.domain.Match;
import refactoring.domain.MatchResults;
import refactoring.domain.MyLadderFactory;
import refactoring.domain.MyLineFactory;
import refactoring.domain.Results;
import refactoring.utils.CommaSplit;
import refactoring.view.InputView;
import refactoring.domain.Players;
import refactoring.view.LadderView;
import refactoring.view.ResultView;

public class LadderGameRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView();
        var players = getPlayers(scanner, inputView);
        var depth = getDepth(scanner, inputView);

        var ladderFactory = LadderFactoryBean.createLadderFactory();
        var ladder = ladderFactory.create(depth, players.size());
        var results = getResults(scanner, inputView);

        var ladderView = new LadderView(players, ladder);
        ladderView.printLadder(results);

        var match = ladder.match(results, new MatchResults());
        printResult(scanner, players, match);
    }

    private static void printResult(final Scanner scanner, final Players players, final Match match) {
        ResultView resultView = new ResultView(match, players);
        resultView.printTargetResult();
        String next = scanner.next();
        resultView.printResult(next);
    }

    private static Results getResults(final Scanner scanner, final InputView inputView) {
        inputView.printExecutionResult();
        String reword = scanner.next();
        String[] rewords = CommaSplit.split(reword);
        return Results.of(rewords);
    }

    private static int getDepth(final Scanner scanner, final InputView inputView) {
        inputView.printDepthComment();
        int depth = scanner.nextInt();
        return depth;
    }

    private static Players getPlayers(final Scanner scanner, final InputView inputView) {
        inputView.printNameComment();
        String names = scanner.nextLine();
        String[] split = CommaSplit.split(names);
        return Players.of(split);
    }

}
