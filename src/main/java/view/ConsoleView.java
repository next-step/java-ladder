package view;

import domain.Ladder;
import domain.Participant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleView {

  private static final ConsoleInputView consoleInputView = new ConsoleInputView();

  public static void main(String[] args) {

    String participantNames = consoleInputView.inputParticipantNames();
    List<Participant> participants = generateParticipants(participantNames);

    int maximumLadderHeight = consoleInputView.inputMaximumLadderHeight();
    Ladder ladder = new Ladder(participants, maximumLadderHeight);

    ConsoleResultView.printCreatedLadder(ladder);
  }

  private static List<Participant> generateParticipants(String participantNames) {

    return Arrays.stream(participantNames.split(","))
        .map(Participant::new)
        .collect(Collectors.toList());
  }
}
