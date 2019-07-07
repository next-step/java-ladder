package ladder.view;

import ladder.domain.*;

import javax.xml.transform.Result;
import java.util.List;
import java.util.NoSuchElementException;

public class ResultView {

    public static void printUsers(Players players) {
        List<String> names = players.getPlayersNames();
        int max = players.getMaxNameLength();

        println(getItems(names, max));
    }

    public static void printResults(List<String> results) {
        int max = results.stream()
                .mapToInt(result -> result.length())
                .max()
                .orElseThrow(NoSuchElementException::new);

        println(getItems(results, max));
    }

    private static String getItems(List<String> names, int max) {
        StringBuilder builder = new StringBuilder();
        names.stream()
                .forEach(name -> builder.append(getRefinedName(name, max)));

        return builder.toString();
    }

    private static String getRefinedName(String name, int max) {
        StringBuilder builder = new StringBuilder();

        builder.append(addSpaces(name.length(), max));
        builder.append(name).append(" ");

        return builder.toString();
    }

    private static String addSpaces(int nameLength, int max) {
        if (nameLength >= max) return "";

        StringBuilder builder = new StringBuilder();
        int offset = max - nameLength;
        for (int i = 0; i < offset; i++) {
            builder.append(" ");
        }

        return builder.toString();
    }

    public static void printLadder(Ladder ladder, int maxNameLength) {
        List<Line> lines = ladder.getLines();
        lines.stream()
                .forEach(line -> println(printLine(line, maxNameLength)));
    }

    private static String printLine(Line line, int maxNameLength) {
        StringBuilder builder = new StringBuilder();
        builder.append("|");

        List<Point> points = line.getPoints();
        for(int i = 0 ; i < points.size() - 1 ; i++) {
            builder.append(printPoint(points.get(i), maxNameLength));
        }

        return builder.toString();
    }

    private static String printPoint(Point point, int maxNameLength) {
        return getLadderBlock(point.current(),  maxNameLength);
    }

    private static String getLadderBlock(boolean isLine, int maxLength) {
        StringBuilder builder = new StringBuilder();
        String type = getLadderType(isLine);
        for (int i = 0 ; i < maxLength + 1 ; i++) {
            builder.append(type);
        }

        builder.append('|');
        return builder.toString();
    }

    public static void printPlayerResult(String result) {
        println("실행 결과");
        println(result);
    }

    public static void printGameResult(List<String> players, List<String> result) {
        println("실행 결과");
        for (int i = 0 ; i < players.size() ; i++) {
            println(players.get(i) + " : " + result.get(i));
        }
    }

    private static String getLadderType(boolean isLine) {
        return isLine ? "-" : " ";
    }

    private static void print(String message) {
        System.out.print(message);
    }

    private static void println(String message) {
        System.out.println(message);
    }
}
