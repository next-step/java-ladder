package ladder;

import ladder.domain.Ladder;
import ladder.domain.Participants;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final int NAME_LENGTH_WIDTH = 6;
    private static final String RESULT_MESSAGE = "\n실행결과\n";

    public static void printResult(Participants participants, Ladder ladder) {
        System.out.println(RESULT_MESSAGE);

        printParticipants(participants);
    }

    private static void printParticipants(Participants participants) {
        String names = participants.getNames()
                .stream()
                .map(name -> name + repeat(" ", NAME_LENGTH_WIDTH - name.length()))
                .collect(Collectors.joining());

        System.out.println(names);
    }

    private static String repeat(String string, int length) {
        return IntStream.range(0, length)
                .mapToObj(i -> string)
                .collect(Collectors.joining(""));
    }
}
