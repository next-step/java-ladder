package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participants;

import java.util.stream.Collectors;

public class OutputView {
    private static final String PARTICIPANT_NAME_FORMAT = "%5s ";
    private static final String LADDER_HORIZONTAL_LINE = "-----";
    private static final String LADDER_EMPTY_SPACE = "     ";
    private static final String LADDER_VERTICAL_LINE = "|";
    private static final String LADDER_SPACE = " ";
    private static final String NEWLINE = System.lineSeparator();
    private static final int MAX_NAME_LENGTH = 5;

    private OutputView() {
    }

    public static void printParticipantNames(Participants participants) {
        System.out.println("실행 결과" + NEWLINE);
        System.out.println(formatParticipantNames(participants));

    }

    public static void printLadders(Lines lines) {
        System.out.println(formatLines(lines));
    }

    private static String formatParticipantNames(Participants participants) {
        int lastIndex = participants.getParticipants().size() - 1;

        String names = participants.getParticipants().stream()
                .limit(lastIndex)
                .map(participantName -> String.format(PARTICIPANT_NAME_FORMAT, participantName.getName()))
                .collect(Collectors.joining());

        return names + String.format(PARTICIPANT_NAME_FORMAT, participants.getParticipants().get(lastIndex).getName());
    }

    private static String formatLines(Lines lines) {
        return lines.getLines().stream()
                .map(OutputView::formatSingleLine)
                .collect(Collectors.joining(NEWLINE)) + NEWLINE;
    }

    private static String formatSingleLine(Line line) {
        StringBuilder ladder = new StringBuilder(LADDER_SPACE.repeat(MAX_NAME_LENGTH) + LADDER_VERTICAL_LINE);

        line.getPoints().stream()
                .map(point -> point ? LADDER_HORIZONTAL_LINE : LADDER_EMPTY_SPACE)
                .forEach(segment -> ladder.append(segment).append(LADDER_VERTICAL_LINE));

        return ladder.toString();
    }
}
