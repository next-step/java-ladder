package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.LadderResults;
import ladder.domain.Participant;

import java.util.stream.Collectors;

public class ResultView {

    private static final String LINE_STRING = "|";
    private static final String CONNECTION_STRING = "-".repeat(Participant.MAXIMUM_NAME_LENGTH);
    private static final String DISCONNECTION_STRING = " ".repeat(Participant.MAXIMUM_NAME_LENGTH);

    private ResultView() {
    }

    public static void printLadder(final Ladder ladder, final LadderResults ladderResults) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();

        System.out.print(" ");
        System.out.println(ladder.getParticipants()
                                 .getParticipants()
                                 .stream()
                                 .map(Participant::getName)
                                 .map(name -> addLeftPaddingString(name, Participant.MAXIMUM_NAME_LENGTH))
                                 .collect(Collectors.joining(" ")));

        final int participantsSize = ladder.getParticipants()
                                           .size();
        for (int h = 0; h < ladder.getHeight(); h++) {
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

        System.out.println(ladderResults.getLadderResults()
                                        .stream()
                                        .map(LadderResult::getValue)
                                        .map(name -> addLeftPaddingString(name, Participant.MAXIMUM_NAME_LENGTH))
                                        .collect(Collectors.joining(" ")));
    }

    public static void printAllLadderResults(final Ladder ladder, final LadderResults ladderResults) {
        System.out.println();
        System.out.println("실행 결과");
        ladder.getParticipants()
              .getParticipants()
              .forEach(participant ->
                      System.out.printf("%s : %s%n",
                              participant.getName(),
                              ladderResults.get(ladder.getLastVerticalLineIndex(participant))
                                           .getValue()));
    }

    public static void printLadderResult(final Ladder ladder,
                                         final LadderResults ladderResults,
                                         final Participant targetParticipant) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println(ladderResults.get(ladder.getLastVerticalLineIndex(targetParticipant))
                                        .getValue());
    }

    private static String addLeftPaddingString(final String string, final int size) {
        return String.format("%" + size + "s", string);
    }

    public static void printConfirmationEndMessage() {
        System.out.println();
        System.out.println("-1을 입력하여 종료합니다.");
    }
}
