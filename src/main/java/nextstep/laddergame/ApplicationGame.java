package nextstep.laddergame;

import nextstep.laddergame.domain.GameResult;
import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.LadderInfo;
import nextstep.laddergame.domain.Member;
import nextstep.laddergame.domain.Members;
import nextstep.laddergame.domain.Prizes;
import nextstep.laddergame.domain.strategy.LineStrategy;
import nextstep.laddergame.domain.strategy.LineStrategyNotTwoWay;
import nextstep.laddergame.domain.strategy.decorator.LineStrategyRandom;
import nextstep.laddergame.factory.MembersFactory;
import nextstep.laddergame.factory.PrizesFactory;
import nextstep.laddergame.ui.InputView;
import nextstep.laddergame.ui.OutputView;

public class ApplicationGame {

  private static final int TRY_NUMBER = 2;
  private static final String PRINT_ALL = "all";

  public static void main(String[] args) {
    Members members = MembersFactory.createMembers(InputView.inputMembers());
    Prizes prizes = PrizesFactory.createPrizes(InputView.inputResults(), members.getSize());
    LadderInfo ladderInfo = new LadderInfo(InputView.inputLadderHeight(), members.getSize());

    LineStrategy lineStrategy = new LineStrategyRandom(new LineStrategyNotTwoWay());
    Ladder ladder = ladderInfo.generateLadder(lineStrategy);
    OutputView.printLadder(members, ladder, prizes);

    GameResult gameResult = ladder.createGameResult(members, prizes);
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
