package ladder.view;

import ladder.domain.LadderResult;
import ladder.domain.*;

import java.util.List;
import java.util.NoSuchElementException;

public class ResultView {

    public static void printResult(LadderResult result) {
        ResultView.printUsers(result.getPlayers());

        ResultView.printLadder(result.getLadder(), result.getPlayers().getMaxNameLength());

        ResultView.printResults(result.getResults());

        String answer;
        answer = InputView.promptThenString("결과를 보고 싶은 사람은?");
        while (!answer.equals("all")) {
            ResultView.printPlayerResult(result.getPlayerResult(answer));
            answer = InputView.promptThenString("결과를 보고 싶은 사람은?");
        }

        ResultView.printGameResult(result.getPlayers().getPlayersNames(), result.getTotalPlayersResult());
    }

    private static void printUsers(Players players) {
        List<String> names = players.getPlayersNames();
        int max = players.getMaxNameLength();

        println(getItems(names, max));
    }

    private static void printResults(List<String> results) {
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

    private static void printLadder(Ladder ladder, int maxNameLength) {
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

    private static void printPlayerResult(String result) {
        println("실행 결과");
        println(result);
    }

    private static void printGameResult(List<String> players, List<String> result) {
        println("실행 결과");
        for (int i = 0 ; i < players.size() ; i++) {
            println(players.get(i) + " : " + result.get(i));
        }
    }

    private static String getLadderType(boolean isLine) {
        return isLine ? "-" : " ";
    }

    private static void println(String message) {
        System.out.println(message);
    }
}
