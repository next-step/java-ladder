package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class ResultView {

    private static final String NEW_LINE = "\n";
    private static final String WHITE_SPACE_CHAR = " ";
    private static final String COLUMN_LINE_CHAR = "|";
    private static final String ROW_LINE_CHAR = "-";
    private static final int ROW_WIDTH_LENGTH = 5;

    private ResultView() {
        throw new IllegalCallerException("잘못된 객체생성 입니다.");
    }

    public static void drawResultMessage() {
        System.out.println("\n실행결과\n");
    }

    public static void drawParticipants(Participants participants) {
        String drewUserNames = drawUserNames(participants);
        System.out.println(drewUserNames);
    }

    public static void drawLadder(Ladder ladder) {
        String drewLines = drawLines(ladder.getLineColumns());
        System.out.println(drewLines);
    }

    private static String drawLines(LineColumns lineColumns) {
        return lineColumns.getColumns()
                .stream()
                .map(column -> drawFirstColumn() + drawRows(column))
                .collect(Collectors.joining(NEW_LINE));
    }

    private static String drawUserNames(Participants participants) {
        return participants.getUserNames()
                .stream()
                .map(name -> String.format("%5s", name))
                .collect(Collectors.joining(WHITE_SPACE_CHAR));
    }

    private static String drawRows(LineRows column) {
        return column.getConnectionStatuses()
                .stream()
                .map(drawRow())
                .collect(Collectors.joining());
    }

    private static Function<ConnectionStatus, String> drawRow() {
        return connectionStatus -> connectionStatus.isConnected() ? drawConnectedRow() : drawUnconnectedRow();
    }

    private static String drawFirstColumn() {
        return repeatChar(ROW_WIDTH_LENGTH - 1, WHITE_SPACE_CHAR) + COLUMN_LINE_CHAR;
    }

    private static String drawConnectedRow() {
        return repeatChar(ROW_WIDTH_LENGTH, ROW_LINE_CHAR) + COLUMN_LINE_CHAR;
    }

    private static String drawUnconnectedRow() {
        return repeatChar(ROW_WIDTH_LENGTH, WHITE_SPACE_CHAR) + COLUMN_LINE_CHAR;
    }

    private static String repeatChar(int repeatCount, String anyChar) {
        return IntStream.rangeClosed(1, repeatCount)
                .mapToObj(n -> anyChar)
                .collect(Collectors.joining());
    }

}
