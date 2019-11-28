package reladder.view;

import reladder.domain.*;
import reladder.service.LadderGame;

import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String LADDER_LINE = "|     ";
    private static final String LADDER_POINT = "|-----";
    private static final String INTERVAL = " ";

    public static void printLadderGame(LadderGame ladderGame) {
        printPeople(ladderGame.getPeople());
        drawLadder(ladderGame.getLadder());
        printResults(ladderGame.getResults());
    }

    private static void drawLadder(List<LadderLine> ladderLines) {
        for (LadderLine ladderLine : ladderLines) {
            drawLadderLine(ladderLine.getPoints());
        }
    }

    private static void drawLadderLine(List<Point> points) {
        for (Point point : points) {
            System.out.print(drawPoint(point));
        }
        System.out.println();
    }

    private static String drawPoint(Point point) {
        if (point.isPrintLadderPoint()) {
            return LADDER_POINT;
        }
        return LADDER_LINE;
    }

    private static void printPeople(List<Person> people) {
        people.forEach(person ->
                System.out.print(person.getName() + printEmptyForCorrection(person.getEmptyLength())));
        System.out.println();
    }

    private static void printResults(List<Result> results) {
        results.forEach(result ->
                System.out.print(result.getName() + printEmptyForCorrection(result.getEmptyLength())));
        System.out.println();
    }

    private static String printEmptyForCorrection(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(INTERVAL);
        }
        return stringBuilder.toString();
    }

    public static void printResult(Map<String, Object> result) {
        System.out.println("실행결과");
        for (Map.Entry<String, Object> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void printResultOnce(String resultName) {
        System.out.println("실행결과");
        System.out.println(resultName);
    }
}
