package nextstep.ladder.ui;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String POINT_TRUE = "-----";
    private static final String POINT_FALSE = "     ";
    private static final String LINE_DELIMITER = "|";

    public static void printLadderGame(LadderGame game, List<String> prizes) {
        System.out.println("실행 결과");
        System.out.println(formatParticipantNames(game.getParticipants()));
        System.out.println(formatLadder(game.getLadder()));
        System.out.println(formatPrizes(prizes));
    }

    private static String formatLadder(Ladder ladder) {
        return ladder.getLines().stream()
                .map(ResultView::formatLine)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static String formatLine(Line line) {
        return line.get().stream()
                .map(point -> String.format("%5s", formatPoint(point)))
                .collect(Collectors.joining(LINE_DELIMITER, String.format("%5s", LINE_DELIMITER), LINE_DELIMITER));
    }

    private static String formatPoint(boolean point) {
        if (point) {
            return POINT_TRUE;
        }
        return POINT_FALSE;
    }

    private static String formatParticipantNames(Participants participants) {
        return participants.get().stream()
                .map(Participant::getName)
                .map(name -> String.format("%-6s", name))
                .collect(Collectors.joining());
    }

    private static String formatPrizes(List<String> prizes) {
        return prizes.stream()
                .map(prize -> String.format("%-6s", prize))
                .collect(Collectors.joining());
    }

    public static void printLadderGameResult(LadderGameResult gameResult, String name) {
        System.out.println("실행 결과");
        System.out.println(formatResult(gameResult, name));
    }

    private static String formatResult(LadderGameResult gameResult, String name) {
        if ("all".equals(name)) {
            return gameResult.getParticipantPositions().stream()
                    .map(position -> formatParticipantPosition(gameResult, position))
                    .collect(Collectors.joining());
        }
        return formatParticipantPosition(gameResult, gameResult.getParticipantPosition(name));
    }

    private static String formatParticipantPosition(LadderGameResult gameResult, ParticipantPosition position) {
        String name = position.getParticipantName();
        return String.format("%s : %s%s", name, gameResult.getPrize(name), System.lineSeparator());
    }

    public static void printException(String message, Exception e) {
        printException(message);
        e.printStackTrace();
    }

    public static void printException(String message) {
        System.out.println(message);
    }
}
