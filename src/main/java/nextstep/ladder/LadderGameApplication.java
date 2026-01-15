package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.ResultQuery;
import nextstep.ladder.domain.Rewards;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGameApplication {

  public static void main(String[] args) {
    Participants participants = new Participants(InputView.inputParticipants());
    Rewards rewards = new Rewards(InputView.inputLadderRewards(participants.size()));
    Height height = new Height(InputView.inputMaxLadderHeight());

    Ladder ladder = new Ladder(participants.size(), height);
    OutputView.printLadderStatus(participants, ladder, rewards);

    LadderGame game = new LadderGame(ladder, rewards);
    LadderGameResult result = game.play(participants);

    ResultQuery query = new ResultQuery(InputView.inputResultQuery());
    while (!query.isAll()) {
      OutputView.printResult(result.getResult(query.getName()));
      query = new ResultQuery(InputView.inputResultQuery());
    }
    OutputView.printAllResults(result);
  }

}
