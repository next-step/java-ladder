package ladder.view;

import java.util.stream.IntStream;
import ladder.domain.Ladders;
import ladder.domain.Participants;

public class OutputView {


  private static final String LADDER = "|-----";
  private static final String NOT_LADDER = "|     ";
  private static final String START_EMPTY_SPACE = "     ";
  private static final String LAST = "|";

  public static void printLadder(Ladders ladders) {
    IntStream.range(0, ladders.height()).forEach(rowNumber -> {
      printStartEmptySpace();
      ladders.getRow(rowNumber).stream()
          .map(OutputView::ladder)
          .forEach(System.out::print);
      printLastLine();
    });
  }

  private static String ladder(Boolean connection) {
    if(connection) {
      return LADDER;
    }
    return NOT_LADDER;
  }

  private static void printLastLine() {
    System.out.println(LAST);
  }

  private static void printStartEmptySpace() {
    System.out.print(START_EMPTY_SPACE);
  }

  public static void printParticipantsNames(Participants participants) {
    participants.getParticipants()
                .forEach(participant -> System.out.printf("%-6s", participant.getName().name()));
    System.out.println();
  }



}
