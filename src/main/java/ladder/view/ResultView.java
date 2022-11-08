package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Participant;

import java.util.stream.Collectors;

public class ResultView {

    private static final String LINE_STRING = "|";
    private static final String CONNECTION_STRING = "-".repeat(Participant.MAXIMUM_NAME_LENGTH);
    private static final String DISCONNECTION_STRING = " ".repeat(Participant.MAXIMUM_NAME_LENGTH);

    private ResultView() {
    }

    public static void print(final Ladder ladder) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();

        System.out.print(" ");
        System.out.println(ladder.getParticipants()
                                 .getParticipants()
                                 .stream()
                                 .map(Participant::getName)
                                 .map(name -> addLeftPaddingString(name, Participant.MAXIMUM_NAME_LENGTH))
                                 .collect(Collectors.joining(" ")));

        final int intLadderHeight = ladder.getHeight()
                                          .getValue();
        final int participantsSize = ladder.getParticipants()
                                           .size();
        for (int h = 0; h < intLadderHeight; h++) {
            for (int i = 0; i < participantsSize; i++) {
                if (i == 0) {
                    System.out.print(DISCONNECTION_STRING + LINE_STRING);
                    continue;
                }

                if (ladder.getLine(h)
                          .isConnected(i - 1)) {
                    System.out.print(CONNECTION_STRING + LINE_STRING);
                    continue;
                }

                System.out.print(DISCONNECTION_STRING + LINE_STRING);
            }
            System.out.println();
        }
    }

    private static String addLeftPaddingString(final String string, final int size) {
        return String.format("%" + size + "s", string);
    }
}
