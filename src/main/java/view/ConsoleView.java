package view;

import domain.Ladder;
import domain.Lines;
import domain.Participant;
import domain.Participants;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleView {

  private static final ConsoleInputView consoleInputView = new ConsoleInputView();

  public static void main(String[] args) {

    String participantNames = consoleInputView.inputParticipantNames();
    Participants participants = generateParticipants(participantNames);

    int maximumLadderHeight = consoleInputView.inputMaximumLadderHeight();
    Ladder ladder = new Ladder(participants, maximumLadderHeight);

    ConsoleResultView.printCreatedLadder(ladder);
  }

  private static Participants generateParticipants(String participantNames) {

    List<Participant> participants = Arrays.stream(participantNames.split(","))
        .map(Participant::new)
        .collect(Collectors.toList());
    return new Participants(participants);
  }
}
