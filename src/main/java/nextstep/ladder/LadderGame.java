package nextstep.ladder;

import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {


  public static void main(String[] args) {
    Participants participants = InputView.readParticipants();
    Results results = InputView.readResults();
    int height = InputView.readLadderHeight();

    Ladder ladder = LadderGenerator.generate(participants.count(), height);
    MappingTable table = new MappingTable(participants, results);
    LadderExecutor executor = new LadderExecutor(ladder, table);

    ResultView.printTitle();
    ResultView.printParticipants(participants);
    ResultView.printLadder(ladder);
    ResultView.printResults(results);

    while (true) {
      String name = InputView.readQuery();
      if (InputView.isAllQuery(name)) {
        ResultView.printAllResults(executor.executeAll());
        break;
      }
      ResultView.printSingleResult(executor.execute(name));
    }

    InputView.closeScanner();
  }

}
