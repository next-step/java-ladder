package ladder.view.output;

import ladder.domain.participant.Participants;

public class OutputNamesView {

  public static void printParticipantsNames(Participants participants) {
    participants.getParticipants()
        .forEach(participant -> System.out.printf("%-6s", participant.name()));
    System.out.println();
  }

}
