package nextstep.ladder.view;

import nextstep.ladder.domain.LadderResults;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;

import java.util.stream.Collectors;

public class OutputView {
    private static final String PARTICIPANT_NAME_FORMAT = "%5s ";
    private static final String LADDER_HORIZONTAL_LINE = "-----";
    private static final String LADDER_EMPTY_SPACE = "     ";
    private static final String LADDER_VERTICAL_LINE = "|";
    private static final String LADDER_SPACE = " ";
    private static final String NEWLINE = System.lineSeparator();
    private static final String PARTICIPANT_NAME_ALL = "all";
    private static final int MAX_NAME_LENGTH = 5;

    private OutputView() {
    }

    public static void printLadders(Lines lines) {
        System.out.println(formatLines(lines));
    }

    public static void printLadderResults(LadderResults ladderResults) {
        System.out.println(formatLadderResults(ladderResults) + NEWLINE);
    }

    public static void printResultByParticipant(Participant inputParticipant, LadderResults ladderResults) {
        printHeader();
        if (inputParticipant.getName().equals(PARTICIPANT_NAME_ALL)) {
            printAllParticipantResults(ladderResults);
        } else {
            printSingleParticipantResult(inputParticipant, ladderResults);
        }
    }

    private static void printAllParticipantResults(LadderResults ladderResults) {
        ladderResults.getLadderResults().forEach((participant, result) ->
                System.out.println(participant.getName() + " : " + result.getResult()));
    }

    private static void printSingleParticipantResult(Participant participant, LadderResults ladderResults) {
        System.out.println(ladderResults.getLadderResultByParticipant(participant).getResult());
    }

    private static void printHeader() {
        System.out.println("실행 결과");
    }

    public static void printParticipantNames(Participants participants) {
        String names = participants.getParticipants().stream()
                .map(participant -> String.format(PARTICIPANT_NAME_FORMAT, participant.getName()))
                .collect(Collectors.joining());

        System.out.println(names);
    }

    private static String formatLines(Lines lines) {
        return lines.getLines().stream()
                .map(OutputView::formatSingleLine)
                .collect(Collectors.joining(NEWLINE));
    }

    private static String formatSingleLine(Line line) {
        StringBuilder ladder = new StringBuilder(LADDER_SPACE.repeat(MAX_NAME_LENGTH) + LADDER_VERTICAL_LINE);

        line.getPoints().stream()
                .map(point -> point ? LADDER_HORIZONTAL_LINE : LADDER_EMPTY_SPACE)
                .forEach(segment -> ladder.append(segment).append(LADDER_VERTICAL_LINE));

        return ladder.toString();
    }

    private static String formatLadderResults(LadderResults ladderResults) {
        return ladderResults.getLadderResults().values().stream()
                .map(ladderResult -> String.format(PARTICIPANT_NAME_FORMAT, ladderResult.getResult()))
                .collect(Collectors.joining());
    }

}
