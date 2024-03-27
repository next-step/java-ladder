package nextstep.ladder.ui;

import nextstep.ladder.domain.*;

import java.util.stream.Collectors;

public class ResultView {

    private static final String POINT_TRUE = "-----";
    private static final String POINT_FALSE = "     ";
    private static final String LINE_DELIMITER = "|";


    public static void printGameResult(LadderGame game) {
        System.out.println("실행 결과");
        System.out.println(formatParticipantNames(game.getParticipants()));
        System.out.println(formatLadder(game.getLadder()));
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

}
