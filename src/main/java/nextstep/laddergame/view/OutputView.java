package nextstep.laddergame.view;

import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.Line;
import nextstep.laddergame.domain.PlayerName;
import nextstep.laddergame.domain.Players;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String PLAYER_NAME_FORMAT = "%-6s";
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

    public void printLadderHeightsInputMessage() {
        printStream.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void printLadder(Players players, Ladder ladder) {
        printStream.println("실행결과");
        printStream.println(renderPlayerNames(players));
        printStream.println(renderLadder(ladder));
    }

    private String renderPlayerNames(Players players) {
        List<PlayerName> playerNames = players.getPlayerNames();
        return playerNames.stream()
                .map(playerName -> String.format(PLAYER_NAME_FORMAT, playerName.toString()))
                .collect(Collectors.joining());
    }

    private String renderLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        return lines.stream()
                .map(this::renderLine)
                .collect(Collectors.joining(NEW_LINE));
    }

    private String renderLine(Line line) {
        List<Boolean> points = line.getPoints();
        return String.format(LINE_RENDERING_FORMAT, points.stream()
                .map(point -> point? CONNECTED_POINT_RENDERING_FORMAT : UNCONNECTED_POINT_RENDERING_FORMAT)
                .collect(Collectors.joining(POINT_DELIMITER)));
    }
}
