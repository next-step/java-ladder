package laddergame.view;

import laddergame.domain.ParticipantName;
import laddergame.dto.LadderDto;
import laddergame.dto.LadderGameResult;
import laddergame.dto.LadderLineDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String BLANK = " ";
    private static final String LADDER_COLUMN = "|";
    private static final String LADDER_LINE_CONNECTION = "-".repeat(ParticipantName.MAX_LENGTH);
    private static final String LADDER_LINE_NOT_CONNECTION = BLANK.repeat(ParticipantName.MAX_LENGTH);

    private OutputView() {
    }

    public static void printResult(LadderGameResult result) {
        printParticipantNames(result.getParticipantNames());
        printLadder(result.getLadder());
        printRewards(result.getRewards());
    }

    private static void printParticipantNames(List<String> participantNames) {
        System.out.println(participantNames.stream()
                .map(OutputView::formatParticipantName)
                .collect(Collectors.joining(BLANK)));
    }

    private static String formatParticipantName(String participantName) {
        int length = participantName.length();
        return BLANK.repeat((ParticipantName.MAX_LENGTH - length) / 2)
                + participantName
                + BLANK.repeat((ParticipantName.MAX_LENGTH - length + 1) / 2);
    }

    private static void printLadder(LadderDto ladder) {
        List<LadderLineDto> lines = ladder.getLines();
        lines.forEach(line -> System.out.println(formatLadderLine(line)));
    }

    private static String formatLadderLine(LadderLineDto line) {
        List<Boolean> connections = line.getConnections();
        StringBuilder content = new StringBuilder(BLANK.repeat(ParticipantName.MAX_LENGTH - 1) + LADDER_COLUMN);
        connections.forEach(connected -> content.append(connected ? LADDER_LINE_CONNECTION : LADDER_LINE_NOT_CONNECTION).append(LADDER_COLUMN));
        return content.toString();
    }

    private static void printRewards(List<String> rewards) {
        rewards.forEach(reward -> System.out.printf("%-5s" + BLANK, reward));
    }

}
