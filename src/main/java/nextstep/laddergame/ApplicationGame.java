package nextstep.laddergame;

import nextstep.laddergame.engine.GameResult;
import nextstep.laddergame.engine.Ladder;
import nextstep.laddergame.engine.LadderCreator;
import nextstep.laddergame.engine.Member;
import nextstep.laddergame.engine.Members;
import nextstep.laddergame.engine.Prizes;
import nextstep.laddergame.engine.strategy.LineStrategy;
import nextstep.laddergame.factory.LineStrategyBean;
import nextstep.laddergame.nextstep.NextStepLadderCreator;
import nextstep.laddergame.nextstep.strategy.LineStrategyNotTwoWay;
import nextstep.laddergame.nextstep.strategy.decorator.LineStrategyRandom;
import nextstep.laddergame.ui.InputView;
import nextstep.laddergame.ui.OutputView;

public class ApplicationGame {

  private static final int TRY_NUMBER = 2;
  private static final String PRINT_ALL = "all";

  public static void main(String[] args) {
    Members members = Members.createMembers(InputView.inputMembers());
    Prizes prizes = Prizes.createPrizes(InputView.inputResults(), members.getSize());

    LadderCreator ladderCreator = new NextStepLadderCreator(InputView.inputLadderHeight(),
        members.getSize());

    LineStrategy lineStrategy = LineStrategyBean.createLineStrategy();
    Ladder ladder = ladderCreator.createLadder(lineStrategy);
    OutputView.printLadder(members, ladder, prizes);

    GameResult gameResult = ladder.play(members, prizes);
    for (int i = 0; i < TRY_NUMBER; i++) {
      String member = InputView.inputMemberOfResult();
      if (member.equals(PRINT_ALL)) {
        OutputView.printGameResult(gameResult);
        continue;
      }
      OutputView.printGameResultOfMember(new Member(member), gameResult);
    }
  }
}
