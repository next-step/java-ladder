package ladder.view.output;

import ladder.domain.Participants;

public class OutputNamesView {

  public static void printParticipantsNames(Participants participants) {
    participants.getParticipants()
        .forEach(participant -> System.out.printf("%-6s", participant.getName().name()));
    System.out.println();
  }

}
