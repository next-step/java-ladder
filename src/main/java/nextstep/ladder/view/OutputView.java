package nextstep.ladder.view;

import nextstep.ladder.domain.Bridge;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Scores;
import nextstep.ladder.dto.LadderGameResultDto;
import nextstep.ladder.dto.LadderResultDto;

import java.util.List;

public class OutputView {
    private static final String NAME_SPACE = "%-6s";
    private static final String LINE_SPACE = "    ";
    private static final String LINE = "|";
    private static final String BRIDGE = "----";
    private static final String COLON = " : ";

    public static void outputLadderResult(LadderResultDto ladderResultDto) {
        System.out.println("실행 결과");
        System.out.println(System.lineSeparator());
        outputNames(ladderResultDto.getPlayers());
        outputLines(ladderResultDto.getLines());
        outputLadderScores(ladderResultDto.getScores());
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
        return stringBuilder;
    }

    private static StringBuilder appendBridge(Bridge bridge, StringBuilder stringBuilder) {
        if (bridge.isRight()) {
            return stringBuilder.append(BRIDGE);
        }

        return stringBuilder.append(LINE_SPACE);
    }

    private static void outputLadderScores(Scores scores) {
        StringBuilder stringBuilder = new StringBuilder();
        scores.getScores()
                .stream()
                .forEach(result -> stringBuilder.append(appendSpace(NAME_SPACE, result)));
        stringBuilder.append(System.lineSeparator());
        System.out.println(stringBuilder);
    }

    public static void outputResults(List<LadderGameResultDto> ladderGameResultDtos, String name) {
        System.out.println("실행 결과");
        LadderGameResultDto ladderGameResultDto = findLadderGameResultDto(ladderGameResultDtos, name);
        StringBuilder stringBuilder = appendResult(ladderGameResultDto.getPlayerName(), ladderGameResultDto.getScore(), new StringBuilder());
        stringBuilder.append(System.lineSeparator());
        System.out.println(stringBuilder);
    }

    public static void outputAllResult(List<LadderGameResultDto> ladderGameResultDtos) {
        System.out.println("실행 결과");
        StringBuilder stringBuilder = new StringBuilder();
        for (LadderGameResultDto ladderGameResultDto : ladderGameResultDtos) {
            stringBuilder = appendResult(ladderGameResultDto.getPlayerName(), ladderGameResultDto.getScore(), stringBuilder);
            stringBuilder.append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }

    private static StringBuilder appendResult(String name, String score, StringBuilder stringBuilder) {
        stringBuilder.append(name);
        stringBuilder.append(COLON);
        stringBuilder.append(score);
        return stringBuilder;
    }

    private static LadderGameResultDto findLadderGameResultDto(List<LadderGameResultDto> ladderGameResultDtos, String name) {
        return ladderGameResultDtos.stream()
                .filter(ladderGameResultDto -> ladderGameResultDto.getPlayerName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("not matched name"));
    }
}
