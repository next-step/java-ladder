package ladder.view;

import ladder.model.gameresult.GameResult;
import ladder.model.gameresult.GameResults;
import ladder.model.ladder.Ladder;
import ladder.model.ladder.Line;
import ladder.model.point.Point;
import ladder.model.player.Player;
import ladder.model.player.Players;
import ladder.model.result.Result;
import ladder.model.result.Results;

import java.util.List;

public class ResultView {

    private static final String LINE = "-----|";
    private static final String NO_LINE = "     |";

    public static void printLadderResult(Players players, Ladder ladder, Results results) {
        System.out.println("사다리 결과");
        System.out.println();
        printPlayerName(players.get());
        printLadder(ladder);
        printResults(results.get());
    }

    private static void printPlayerName(List<Player> players) {
        players.forEach(player -> System.out.printf("%5s ", player.name()));
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        ladder.lines().forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {
        line.points()
                .get()
                .forEach(ResultView::printPoint);
        System.out.println();
    }

    private static void printPoint(Point point) {
        String value = NO_LINE;
        if(point.isLeft())  {
            value = LINE;
        }
        System.out.print(value);
    }

    private static void printResults(List<Result> results) {
        results.forEach(result -> System.out.printf("%5s ", result.get()));
        System.out.println();
    }

    public static void printResult(GameResults gameResults, Results results) {
        System.out.println("실행 결과");
        gameResults.get().forEach(gameResult ->
                System.out.println(printGameResult(gameResults.isAll(), gameResult, results)));
    }

    private static String printGameResult(boolean all, GameResult gameResult, Results results) {
        if(all) {
            return gameResult.name() + " : " + results.get(gameResult.resultIndex()).get();
        }
        return results.get(gameResult.resultIndex()).get();
    }
}
