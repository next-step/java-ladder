package nextstep.ladder.view;

import nextstep.ladder.domain.Bridge;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;
import nextstep.ladder.dto.LadderResultDto;

import java.util.List;

public class OutputView {
    private static final String NAME_SPACE = "%-6s";
    private static final String LINE_SPACE = "    ";
    private static final String LINE = "|";
    private static final String BRIDGE = "----";

    public static void outputLadderResult(LadderResultDto ladderResultDto) {
        System.out.println("실행 결과");
        System.out.println(System.lineSeparator());
        outputNames(ladderResultDto.getPlayers());
        outputLines(ladderResultDto.getLines());
    }

    private static void outputNames(List<Player> players) {
        StringBuilder stringBuilder = new StringBuilder();
        players.stream()
                .map(player -> appendSpace(NAME_SPACE, player.getName()))
                .forEach(name -> stringBuilder.append(name));
        System.out.println(stringBuilder);
    }

    private static String appendSpace(String format, String name) {
        return String.format(format, name);
    }

    private static void outputLines(List<Line> lines) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Line line : lines) {
            stringBuilder = appendLine(line, stringBuilder);
            stringBuilder.append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }

    private static StringBuilder appendLine(Line line, StringBuilder stringBuilder) {
        stringBuilder.append(appendSpace(LINE_SPACE, ""));
        for (Bridge bridge : line.getBridges()) {
            stringBuilder.append(LINE);
            stringBuilder = appendBridge(bridge, stringBuilder);
        }
        stringBuilder.append(LINE);
        return stringBuilder;
    }

    private static StringBuilder appendBridge(Bridge bridge, StringBuilder stringBuilder) {
        if (bridge.isCross()) {
            return stringBuilder.append(BRIDGE);
        }

        return stringBuilder.append(LINE_SPACE);
    }
}
