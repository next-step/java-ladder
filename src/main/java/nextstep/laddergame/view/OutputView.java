package nextstep.laddergame.view;

import nextstep.laddergame.domain.*;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LIST_RENDERING_FORMAT = "%-6s";
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String LINE_RENDERING_FORMAT = "|%s|";
    private static final String CONNECTED_POINT_RENDERING_FORMAT = "-----";
    private static final String UNCONNECTED_POINT_RENDERING_FORMAT = "     ";
    private static final String POINT_DELIMITER = "|";

    private final PrintStream printStream;

    private OutputView(PrintStream printStream) {
        this.printStream = printStream;
    }

    public static OutputView of(PrintStream printStream) {
        return new OutputView(printStream);
    }

    public void printPlayersNameInputMessage() {
        printStream.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void printPlayResultsInputMessage() {
        printStream.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public void printLadderHeightsInputMessage() {
        printStream.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void printLadder(Players players, Ladder ladder, PlayResults playResults) {
        printStream.println("실행결과");
        printStream.println(render(players.getPlayerNames()));
        printStream.println(renderLadder(ladder));
        printStream.println(render(playResults.getResults()));
    }

    private String render(List<String> strings) {
        return strings.stream()
                .map(str -> String.format(LIST_RENDERING_FORMAT, str))
                .collect(Collectors.joining());
    }

    private String renderLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        return lines.stream()
                .map(this::renderLine)
                .collect(Collectors.joining(NEW_LINE));
    }

    private String renderLine(Line line) {
        List<Point> points = line.getPoints();
        return String.format(LINE_RENDERING_FORMAT, points.stream()
                .map(point -> point.isConnected()? CONNECTED_POINT_RENDERING_FORMAT : UNCONNECTED_POINT_RENDERING_FORMAT)
                .collect(Collectors.joining(POINT_DELIMITER)));
    }
}
