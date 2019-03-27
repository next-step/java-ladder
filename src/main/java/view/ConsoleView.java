package view;

import domain.Ladder;
import domain.Participant;
import domain.Participants;
import domain.Result;
import domain.Results;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleView {

  private static final ConsoleInputView consoleInputView = new ConsoleInputView();

  public static void main(String[] args) {

    String participantNames = consoleInputView.inputParticipantNames();
    Participants participants = generateParticipants(participantNames);

    String inputExecuteResults = consoleInputView.inputExecuteResults();
    Results results = generateResults(inputExecuteResults);
    Ladder ladder = new Ladder(participants, results);

    int maximumLadderHeight = consoleInputView.inputMaximumLadderHeight();
    ladder.create(maximumLadderHeight);

    ConsoleResultView.printCreatedLadder(ladder);

    String participantName = consoleInputView.inputViewResultParticipantName();
    while (!participantName.equals("all")) {

      Result result = ladder.result(new Participant(participantName));
      ConsoleResultView.printResult(result);

      participantName = consoleInputView.inputViewResultParticipantName();
    }

    Map<Participant, Result> resultsByParticipants = ladder.resultsByParticipant(participants);
    ConsoleResultView.printLadderResults(resultsByParticipants);
  }

  private static Results generateResults(String executeResults) {

    List<Result> results = Arrays.stream(executeResults.split(","))
        .map(Result::new)
        .collect(Collectors.toList());
    return new Results(results);
  }

  private static Participants generateParticipants(String participantNames) {

    List<Participant> participants = Arrays.stream(participantNames.split(","))
        .map(Participant::new)
        .collect(Collectors.toList());
    return new Participants(participants);
  }
}
