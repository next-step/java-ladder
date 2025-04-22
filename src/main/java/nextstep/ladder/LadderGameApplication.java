package nextstep.ladder;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResults;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.RandomPointStrategy;
import nextstep.ladder.domain.ResultMappings;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameApplication {

  public static void main(String[] args) {
    List<String> participantNameList = InputView.getParticipantNames();
    List<String> executionResult = InputView.getExecutionResult();
    int height = InputView.getLadderHeight();

    Participants participants = new Participants(participantNameList);
    LadderResults ladderResults = new LadderResults(executionResult);
    Ladder ladder = Ladder.of(height, participantNameList.size(), new RandomPointStrategy());

    ResultView.printLadder(participants, ladder, ladderResults);

    ResultMappings mappings = new ResultMappings();
    participants.findResults(ladder, ladderResults, mappings);

    while (true) {
      String query = InputView.getQueryName();
      if ("all".equals(query)) {
        System.out.println("실행 결과");
        mappings.printAll();
        break;
      }
      System.out.println("실행 결과");
      mappings.printFor(query);
    }
  }



}
