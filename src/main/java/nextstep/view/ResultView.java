package nextstep.view;

import nextstep.domain.ladder.Ladder;
import nextstep.domain.line.Line;
import nextstep.domain.line.Point;
import nextstep.domain.player.Players;

import java.util.stream.Collectors;

public class ResultView {
    private static final String BLANK = " ";
    private static final String WALL = "|";
    private static final String LINE = "-----";
    private static final String EMPTY_LINE = "     ";
    private static final String RESULT_MESSAGE = "실행결과";
    private static final int MAX_NAME_LENGTH = 6;

    public static void printLadderView(Players players, Ladder ladder) {
        System.out.println(RESULT_MESSAGE);
        System.out.println();

        printPlayerNames(players);
        printLadderResult(ladder);
    }

    private static void printPlayerNames(Players players) {
        String allPlayersName = players.getPlayerNames().stream()
                .map(ResultView::printFullPlayerNames)
                .collect(Collectors.joining());
        System.out.println(allPlayersName);
    }

    private static void printLadderResult(Ladder ladder) {
        ladder.getAllLines()
                .forEach(ResultView::printLines);
    }

    private static void printLines(Line line){
        System.out.print(EMPTY_LINE);
        line.getPoints().forEach(point ->
            System.out.print(WALL+ isLineOrBlank(point)));
        System.out.println(WALL);
    }

    private static String isLineOrBlank(Point point){
        if(point.isConnected()) {
            return LINE;
        }
        return EMPTY_LINE;
    }

    private static String printFullPlayerNames(String name){
        return BLANK.repeat(MAX_NAME_LENGTH - name.length()) + name;
    }
}
