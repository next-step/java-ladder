package laddergame.view;

import laddergame.domain.LadderGameResult;
import laddergame.domain.LadderLineConnections;
import laddergame.domain.ParticipantName;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String BLANK = " ";
    private static final String LADDER_COLUMN = "|";
    private static final String LADDER_CONNECTION = "-".repeat(ParticipantName.MAX_LENGTH);
    private static final String LADDER_NOT_CONNECTION = BLANK.repeat(ParticipantName.MAX_LENGTH);

    private OutputView() {}

    public static void printResult(LadderGameResult result) {
        printParticipantNames(result.getParticipantNames());
        printLadder(result.getConnectionsByHeight());
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

    private static void printLadder(List<LadderLineConnections> connectionsByHeight) {
        connectionsByHeight.stream()
                .map(OutputView::formatLadderLineConnections)
                .forEach(System.out::println);
    }

    private static String formatLadderLineConnections(LadderLineConnections connections) {
        StringBuilder content = new StringBuilder(BLANK.repeat(ParticipantName.MAX_LENGTH - 1) + LADDER_COLUMN);
        for (int i = 0; i < connections.size(); i++) {
            content.append(connections.isConnected(i) ? LADDER_CONNECTION : LADDER_NOT_CONNECTION)
                    .append(LADDER_COLUMN);
        }
        return content.toString();
    }

}
