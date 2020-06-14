package nextstep.ladder.view;

import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.LadderLine;
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
        outputNames(ladderResultDto.getPlayerNames());
        outputLines(ladderResultDto.getLadderLines());
        outputLadderScores(ladderResultDto.getScores());
    }

    private static void outputNames(List<String> playerNames) {
        StringBuilder stringBuilder = new StringBuilder();
        playerNames.stream()
                .map(name -> appendSpace(NAME_SPACE, name))
                .forEach(name -> stringBuilder.append(name));
        System.out.println(stringBuilder);
    }

    private static String appendSpace(String format, String name) {
        return String.format(format, name);
    }

    private static void outputLines(List<LadderLine> ladderLines) {
        StringBuilder stringBuilder = new StringBuilder();
        for (LadderLine ladderLine : ladderLines) {
            stringBuilder = appendLine(ladderLine, stringBuilder);
            stringBuilder.append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }

    private static StringBuilder appendLine(LadderLine ladderLine, StringBuilder stringBuilder) {
        stringBuilder.append(appendSpace(LINE_SPACE, ""));
        for (Point point : ladderLine.getPoints()) {
            stringBuilder.append(LINE);
            stringBuilder = appendPoint(point, stringBuilder);
        }
        return stringBuilder;
    }

    private static StringBuilder appendPoint(Point point, StringBuilder stringBuilder) {
        if (point.isRight()) {
            return stringBuilder.append(BRIDGE);
        }

        return stringBuilder.append(LINE_SPACE);
    }

    private static void outputLadderScores(List<String> scores) {
        StringBuilder stringBuilder = new StringBuilder();
        scores
                .stream()
                .forEach(result -> stringBuilder.append(appendSpace(NAME_SPACE, result)));
        stringBuilder.append(System.lineSeparator());
        System.out.println(stringBuilder);
    }

    public static void outputResults(LadderGameResultDto ladderGameResultDto) {
        System.out.println("실행 결과");
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
}
