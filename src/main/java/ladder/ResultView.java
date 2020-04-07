package ladder;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class ResultView {

    public static final String LINE = "-----|";
    public static final String EMPTY_LINE = "     |";
    public static final String DEFAULT_EMPTY_SPACE = "    |";
    public static final String USER_INTERVAL = "%5s ";

    public static void printResult(List<String> users, List<Line> ladder) {
        printMessage("실행결과");

        renderUsers(users);
        renderLadderLine(ladder);
    }

    private static void renderUsers(List<String> users) {
        for (String user : users) {
            System.out.print(String.format(USER_INTERVAL, user));
        }
        printMessage("");
    }

    private static void renderLadderLine(List<Line> ladder) {
        ladder.forEach(ResultView::renderOneLine);
    }

    private static void renderOneLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DEFAULT_EMPTY_SPACE);
        stringBuilder.append(buildOneLine(line.getPoints()));

        printMessage(stringBuilder.toString());
    }

    private static String buildOneLine(List<Boolean> points) {
        return points.stream()
                .map(p -> p ? LINE : EMPTY_LINE)
                .limit(points.size() - 1)
                .collect(joining(""));
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
