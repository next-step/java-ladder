package nextstep.ladder.view;

import java.util.List;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Position;

public class OutputView {
    private static final String EXECUTION_RESULT_INTRO = "실행결과";
    private static final String PARTICIPANT_NAME_PRINT_FORMAT = "%6s";
    private static final String LADDER_LINE_EXIST = "-----|";
    private static final String LADDER_LINE_NON_EXIST = "     |";

    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    private OutputView() {
        throw new AssertionError();
    }

    public static void printParticipants(List<Participant> participants) {
        System.out.println(EXECUTION_RESULT_INTRO);
        printParticipantNames(participants);
    }

    public static void printLadder(List<Line> lines) {
        for (Line line : lines) {
            printLines(line.getPositions());
        }
        System.out.println(STRING_BUILDER);
    }

    private static void printLines(List<Position> positions) {
        for(int i = 0; i < positions.size(); i++) {
            STRING_BUILDER.append(printLine(positions.get(i).hasValue()));
        }
        STRING_BUILDER.append("\n");
    }

    private static String printLine(boolean hasValue) {
        if(hasValue) {
            return LADDER_LINE_EXIST;
        }

        return LADDER_LINE_NON_EXIST;
    }

    private static void printParticipantNames(List<Participant> participants) {
        for (Participant participant : participants) {
            System.out.print(String.format(PARTICIPANT_NAME_PRINT_FORMAT, participant.toString()));
        }
        System.out.println();
    }
}
