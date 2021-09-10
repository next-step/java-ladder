package nextstep.laddergame.view;

import nextstep.laddergame.domain.*;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LIST_RENDERING_FORMAT = "%-6s";
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String LINE_RENDERING_FORMAT = "|%s|";
    private static final String CONNECTED_POINT_RENDERING_FORMAT = "-----";
    private static final String UNCONNECTED_POINT_RENDERING_FORMAT = "     ";
    private static final String POINT_DELIMITER = "|";
    private static final String ALL_PLAYER_RESULT = "all";
    private static final String NAME_AND_RESULT_RENDERING_FORMAT = "%s : %s";

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
        printStream.println("사다리 결과");
        printStream.println(renderPlayerNames(players.getPlayerNames()));
        printStream.println(renderLadder(ladder));
        printStream.println(render(playResults.getResults()));
    }

    private String render(List<String> strings) {
        return strings.stream()
                .map(str -> String.format(LIST_RENDERING_FORMAT, str))
                .collect(Collectors.joining());
    }

    private String renderPlayerNames(List<PlayerName> playerNames) {
        return playerNames.stream()
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
        List<LineConnection> connections = line.getConnections();
        return String.format(LINE_RENDERING_FORMAT, connections.stream()
                .map(connection -> connection.isConnected()? CONNECTED_POINT_RENDERING_FORMAT : UNCONNECTED_POINT_RENDERING_FORMAT)
                .collect(Collectors.joining(POINT_DELIMITER)));
    }

    public void printResultCheckInputMessage() {
        printStream.println("결과를 보고 싶은 사람은?");
    }

    public void printPlayResult(Map<PlayerName, String> results, String name) {
        printStream.println("실행 결과");
        if (ALL_PLAYER_RESULT.equals(name)) {
            printStream.println(render(results));
            return;
        }
        if (results.containsKey(PlayerName.of(name))) {
            printStream.println(results.get(PlayerName.of(name)));
            return;
        }
        printStream.println("존재하지 않는 이름입니다.");
    }

    private String render(Map<PlayerName, String> results) {
        return results.entrySet()
                .stream()
                .map(nameAndResult -> String.format(NAME_AND_RESULT_RENDERING_FORMAT, nameAndResult.getKey(), nameAndResult.getValue()))
                .collect(Collectors.joining(NEW_LINE));
    }
}
