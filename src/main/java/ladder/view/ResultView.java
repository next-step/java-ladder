package ladder.view;

import ladder.domain.LadderBoard;
import ladder.domain.Line;
import ladder.domain.Point;

import java.util.List;

public class ResultView {

    private static String EMPTY_POINT_REPRESENTATION = "     ";

    private static String FILLED_POINT_REPRESENTATION = "-----";

    private static String VERTICAL_LINE_REPRESENTATION = "|";

    private static int FIXED_PLAYER_NAME_SPACE = 6;

    public static void printLadderBoard(LadderBoard ladderBoard) {
        System.out.println(MessageConstant.GAME_RESULT);
        printPlayerNameList(ladderBoard.playerNameList());
        for (Line line : ladderBoard.lineList()) {
            printLine(line);
            printEmptyLine();
        }
    }

    private static void printPlayerNameList(List<String> playerNameList) {
        playerNameList.stream()
                .map(playerName -> String.format("%" + FIXED_PLAYER_NAME_SPACE + "." + FIXED_PLAYER_NAME_SPACE + "s", playerName))
                .forEach(System.out::print);
        printEmptyLine();
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    private static void printLine(Line line) {
        List<Point> pointList = line.getPointList();
        for (Point point : pointList) {
            System.out.print(pointRepresentation(point));
            System.out.print(VERTICAL_LINE_REPRESENTATION);
        }
    }

    private static String pointRepresentation(Point point) {
        if (point.isFilled()) {
            return FILLED_POINT_REPRESENTATION;
        }
        return EMPTY_POINT_REPRESENTATION;
    }

}

