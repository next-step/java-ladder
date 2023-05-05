package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.function.Function;
import java.util.stream.Collectors;

public final class ResultView {

    private static final String FIRST_COLUMN = "    |";
    private static final String NEW_LINE = "\n";
    private static final String CONNECTED_ROW = "-----|";
    private static final String UNCONNECTED_ROW = "     |";

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
                .map(column -> FIRST_COLUMN + drawRows(column))
                .collect(Collectors.joining(NEW_LINE));
    }

    private static String drawUserNames(Participants participants) {
        return participants.getUserNames()
                .stream()
                .map(UserName::getName)
                .map(name -> String.format("%5s", name))
                .collect(Collectors.joining(" "));
    }

    private static String drawRows(LineRows column) {
        return column.getConnectionStatuses()
                .stream()
                .map(drawRow())
                .collect(Collectors.joining());
    }

    private static Function<ConnectionStatus, String> drawRow() {
        return connectionStatus -> connectionStatus.isConnected() ? CONNECTED_ROW : UNCONNECTED_ROW;
    }

}
