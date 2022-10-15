package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.domain.LadderGameResult;
import laddergame.domain.LadderLine;
import laddergame.domain.ParticipantName;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String BLANK = " ";
    private static final String LADDER_COLUMN = "|";
    private static final String LADDER_LINE_CONNECTION = "-".repeat(ParticipantName.MAX_LENGTH);
    private static final String LADDER_LINE_NOT_CONNECTION = BLANK.repeat(ParticipantName.MAX_LENGTH);

    private OutputView() {}

    public static void printResult(LadderGameResult result) {
        printParticipantNames(result.getParticipantNames());
        printLadder(result.getLadder());
    }

    private static void printParticipantNames(List<ParticipantName> participantNames) {
        System.out.println(participantNames.stream()
                .map(OutputView::formatParticipantName)
                .collect(Collectors.joining(BLANK)));
    }

    private static String formatParticipantName(ParticipantName participantName) {
        int length = participantName.getLength();
        return BLANK.repeat((ParticipantName.MAX_LENGTH - length) / 2)
                + participantName
                + BLANK.repeat((ParticipantName.MAX_LENGTH - length + 1) / 2);
    }

    private static void printLadder(Ladder ladder) {
        for (int i = 0; i < ladder.getHeight(); i++) {
            System.out.println(formatLadderLine(ladder.getLine(i)));
        }
    }

    private static String formatLadderLine(LadderLine line) {
        StringBuilder content = new StringBuilder(BLANK.repeat(ParticipantName.MAX_LENGTH - 1) + LADDER_COLUMN);
        for (int i = 0; i < line.size(); i++) {
            content.append(line.isConnected(i) ? LADDER_LINE_CONNECTION : LADDER_LINE_NOT_CONNECTION)
                    .append(LADDER_COLUMN);
        }
        return content.toString();
    }

}
