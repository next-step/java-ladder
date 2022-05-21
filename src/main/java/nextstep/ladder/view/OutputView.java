package nextstep.ladder.view;

import java.util.List;
import java.util.Map;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Position;
import nextstep.ladder.dto.ExecutionResultDto;

public class OutputView {
    private static final String ALL_PARTICIPANT_RESULT = "all";
    private static final String LADDER_RESULT_INTRO = "사다리 결과";
    private static final String EXECUTION_RESULT_INTRO = "실행결과";
    private static final String PARTICIPANT_NAME_PRINT_FORMAT = "%6s";
    private static final String RESULT_PRINT_FORMAT = "%6s";
    private static final String LADDER_LINE_EXIST = "-----|";
    private static final String LADDER_LINE_NON_EXIST = "     |";
    private static final String LINE_BREAK = "\n";

    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    private OutputView() {
        throw new AssertionError();
    }

    public static void printLadderResult(List<Participant> participants, List<Line> lines) {
        printParticipants(participants);
        printLadder(lines);
    }

    private static void printParticipants(List<Participant> participants) {
        initStringBuilder();
        System.out.println(LADDER_RESULT_INTRO);
        printParticipantNames(participants);
    }

    public static void printLadder(List<Line> lines) {
        initStringBuilder();
        for (Line line : lines) {
            printLines(line.getPositions());
        }
        System.out.println(STRING_BUILDER);
    }

    public static void printResults(List<String> results) {
        initStringBuilder();
        for (String result : results) {
            STRING_BUILDER.append(String.format(RESULT_PRINT_FORMAT, result));
        }
        STRING_BUILDER.append(LINE_BREAK);
        System.out.println(STRING_BUILDER);
    }

    private static void printLines(List<Position> positions) {
        for (int i = 0; i < positions.size(); i++) {
            STRING_BUILDER.append(printLine(positions.get(i).hasValue()));
        }
        STRING_BUILDER.append(LINE_BREAK);
    }

    private static String printLine(boolean hasValue) {
        if (hasValue) {
            return LADDER_LINE_EXIST;
        }

        return LADDER_LINE_NON_EXIST;
    }

    private static void printParticipantNames(List<Participant> participants) {
        for (Participant participant : participants) {
            STRING_BUILDER.append(String.format(PARTICIPANT_NAME_PRINT_FORMAT, participant.toString()));
        }

        printStringBuilder();
    }

    private static void initStringBuilder() {
        STRING_BUILDER.setLength(0);
    }

    private static void printStringBuilder() {
        System.out.println(STRING_BUILDER);
    }

    public static void printLadderRideResult(ExecutionResultDto executionResultDto, String participant) {
        initStringBuilder();
        System.out.println(EXECUTION_RESULT_INTRO);
        if (ALL_PARTICIPANT_RESULT.equals(participant)) {
            printLadderRideAllResult(executionResultDto);
        }

        if (!ALL_PARTICIPANT_RESULT.equals(participant)) {
            STRING_BUILDER.append(executionResultDto.getExecutionResult(participant));
            STRING_BUILDER.append(LINE_BREAK);
        }

        System.out.println(STRING_BUILDER);
    }

    private static void printLadderRideAllResult(ExecutionResultDto executionResultDto) {
        STRING_BUILDER.append(executionResultDto.executionAllResult());
    }
}
