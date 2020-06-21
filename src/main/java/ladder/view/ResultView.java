package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderLine;
import ladder.domain.ladder.Point;
import ladder.domain.player.Players;
import ladder.domain.result.LadderResult;
import ladder.domain.result.LadderResults;
import ladder.domain.result.MatchResult;

import java.util.stream.IntStream;

public class ResultView {

    public static final String COLUMN = "|";
    public static final String BLANK_LINE = "     ";
    public static final String LINE = "-----";
    public static final String ALL = "all";

    public void printLadder(Players players, Ladder ladder, LadderResults ladderResults) {
        System.out.println("\n사다리 결과\n");
        printPlayer(players);
        printLadder(ladder);
        printResult(ladderResults);
    }

    private void printPlayer(Players players) {
        IntStream.range(0, players.getCountOfPerson())
                .mapToObj(players::get)
                .map(player -> String.format("%6s", player.getName()))
                .forEach(System.out::print);
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        ladder.getLines().forEach(this::printLine);
    }

    private void printLine(LadderLine line) {
        System.out.print(BLANK_LINE);
        line.getPoints().forEach(point -> System.out.print(COLUMN + getLine(point)));
        System.out.println();
    }

    private void printResult(LadderResults ladderResults) {
        IntStream.range(0, ladderResults.size())
                .mapToObj(ladderResults::get)
                .map(LadderResult::getResult)
                .map(result -> String.format("%6s", result))
                .forEach(System.out::print);
    }

    private String getLine(Point point) {
        if (point.isConnectedNextPoint()) {
            return LINE;
        }
        return BLANK_LINE;
    }

    public void printGameResult(String name, Players players, MatchResult matchResult) {
        System.out.println("\n실행결과");
        if (name.equals(ALL)) {
            printAllResultPosition(players, matchResult);
            return;
        }
        printResultPosition(matchResult.get(players.get(name)));
    }

    public void printResultPosition(LadderResult result) {
        System.out.println(result.getResult());
    }

    public void printAllResultPosition(Players players, MatchResult matchResult) {
        IntStream.range(0, players.getCountOfPerson())
                .mapToObj(players::get)
                .map(key -> key.getName() + " : " + matchResult.get(key).getResult())
                .forEach(System.out::println);
    }
}
