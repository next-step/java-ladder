package nextstep.ladder;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.RandomPointStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameApplication {

  public static void main(String[] args) {
    List<String> participantNameList = InputView.getParticipantNames();
    int height = InputView.getLadderHeight();

    Participants participants = new Participants(participantNameList);
    Ladder ladder = Ladder.of(height, participantNameList.size(), new RandomPointStrategy());

    ResultView.printResult(participants, ladder);

  }

}
