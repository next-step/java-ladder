package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.ConnectionStatus;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Points;
import nextstep.ladder.domain.user.ExecuteResults;
import nextstep.ladder.domain.user.Participants;
import nextstep.ladder.domain.user.UserName;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class ResultView {

    private static final String NEW_LINE = "\n";
    private static final String WHITE_SPACE_CHAR = " ";
    private static final String COLUMN_LINE_CHAR = "|";
    private static final String ROW_LINE_CHAR = "-";

    private ResultView() {
        throw new IllegalCallerException("잘못된 객체생성 입니다.");
    }

    public static void drawInputResult(Participants participants,
                                       ExecuteResults executeResults,
                                       Ladder ladder) {
        System.out.println("\n실행결과\n");
        drawParticipants(participants);
        drawLadder(ladder);
        drawExecuteResults(executeResults);
    }

    public static void drawParticipants(Participants participants) {
        String drewUserNames = drawUserNames(participants);
        System.out.println(drewUserNames);
    }

    public static void drawLadder(Ladder ladder) {
        String drewLines = drawLines(ladder.getRows());
        System.out.println(drewLines);
    }

    private static String drawLines(List<Points> rows) {
        return rows.stream()
                .map(points -> drawFirstColumn() + drawRows(points))
                .collect(Collectors.joining(NEW_LINE));
    }

    private static String drawUserNames(Participants participants) {
        return String.join(WHITE_SPACE_CHAR, participants.getFormattedUserNames());
    }

    private static String drawRows(Points points) {
        return points.getConnectionStatuses()
                .stream()
                .map(drawRow())
                .collect(Collectors.joining());
    }

    private static Function<ConnectionStatus, String> drawRow() {
        return connectionStatus -> connectionStatus.isConnected() ? drawConnectedRow() : drawUnconnectedRow();
    }

    private static String drawFirstColumn() {
        return repeatChar(UserName.getMaxLength() - 1, WHITE_SPACE_CHAR) + COLUMN_LINE_CHAR;
    }

    private static String drawConnectedRow() {
        return repeatChar(UserName.getMaxLength(), ROW_LINE_CHAR) + COLUMN_LINE_CHAR;
    }

    private static String drawUnconnectedRow() {
        return repeatChar(UserName.getMaxLength(), WHITE_SPACE_CHAR) + COLUMN_LINE_CHAR;
    }

    private static String repeatChar(int repeatCount, String anyChar) {
        return IntStream.rangeClosed(1, repeatCount)
                .mapToObj(n -> anyChar)
                .collect(Collectors.joining());
    }

    public static void drawExecuteResults(ExecuteResults executeResults) {
        System.out.println(executeResults);
    }

    public static void drawUserResult(String... results) {
        System.out.println("\n실행결과");
        Arrays.stream(results)
                .forEach(System.out::println);
    }

}
