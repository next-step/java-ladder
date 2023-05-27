package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.result.GameResult;
import ladder.domain.Ladder;
import ladder.domain.result.LadderResult;
import ladder.domain.line.Line;
import ladder.domain.name.Name;
import ladder.domain.name.Names;

public class OutputView {

    public static void printResult() {
        System.out.println("\n실행결과\n");
    }

    public static void printLadderResult() {
        System.out.println("사다리 결과\n");
    }

    public static void printGameResultOf() {
        System.out.println("결과를 보고 싶은 사람은?");
    }

    public static void printNames(Names names, int width) {
        System.out.println(joinString(horizontalDelimiter(Delimiter.WHITE_SPACE.value(), width), names.names()));
    }

    public static void printLadder(Ladder ladder, int width) {
        System.out.println(ladderIndicator(ladder, width));
    }

    public static void printLadderResult(LadderResult ladderResult, int width) {
        System.out.println(joinResultString(horizontalDelimiter(Delimiter.WHITE_SPACE.value(), width), ladderResult.results()));
    }

    public static void printGameResultOf(GameResult gameResult, LadderResult ladderResult, Name name) {
        System.out.println(ladderResult.results().get(gameResult.resultOf(name)));
    }

    private static String joinResultString(String delimiter, List<String> results) {
        return String.join(delimiter, results);
    }

    private static String joinString(String delimiter, List<Name> list) {
        return String.join(delimiter, list.stream().map(Name::name).collect(Collectors.toList()));
    }

    private static String horizontalDelimiter(String delimiter, int length) {
        return IntStream.range(0, length)
            .mapToObj(i -> delimiter)
            .collect(Collectors.joining());
    }

    private static String ladderIndicator(Ladder ladder, int width) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Line line : ladder.lines()) {
            stringBuilder.append(verticalLine())
                .append(rightPartOfLine(line, width))
                .append(lineSeparator());
        }
        return stringBuilder.toString();
    }

    private static String lineSeparator() {
        return Delimiter.LINE_SEPARATOR.value();
    }

    private static String verticalLine() {
        return Delimiter.VERTICAL_LINE.value();
    }

    private static String rightPartOfLine(Line line, int width) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Boolean point : line.points()) {
            stringBuilder.append(horizontalDelimiter(delimiterOf(point), width))
                .append(verticalLine());
        }
        return stringBuilder.toString();
    }

    private static String delimiterOf(Boolean point) {
        return point.equals(Boolean.TRUE) ? Delimiter.HORIZONTAL_LINE.value() : Delimiter.WHITE_SPACE.value();
    }

    public static void printGameResultOfAll(GameResult gameResult, LadderResult ladderResult, Names names) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("실행 결과\n");
        for (Name name : names.names()) {
            stringBuilder.append(name.name())
                .append(" : ")
                .append(ladderResult.results().get(gameResult.resultOf(name)))
                .append("\n");
        }
        System.out.println(stringBuilder);
    }

}
