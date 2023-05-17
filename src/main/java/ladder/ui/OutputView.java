package ladder.ui;

import java.util.stream.Collectors;
import ladder.domain.Line;
import ladder.domain.Participants;

public class OutputView {

    private static final String OPEN = "-----|";

    private static final String CLOSE = "     |";

    private static final String RESULT = "실행결과";

    private static final String BLANK = " ";

    private static final int MAX_NAME_LENGTH = 5;

    public static void resultBanner() {
        printSource(RESULT);
    }

    public static void printParticipants(Participants participants) {
        System.out.println(participants.immutableGet().stream()
                .map(participant -> BLANK.repeat(participant.restSpace())
                        + participant + BLANK)
                .collect(Collectors.joining()));
    }

    public static void printLine(Line line) {
        System.out.println(line.immutableGet().stream()
                .map(point -> point? OPEN : CLOSE).collect(Collectors.joining()));
    }

    private static void printSource(String source) {
        System.out.println(source);
    }

}
