package nextstep.laddergame;

import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.LadderInfo;
import nextstep.laddergame.domain.Members;
import nextstep.laddergame.domain.strategy.LineStrategy;
import nextstep.laddergame.domain.strategy.LineStrategyNotTwoWay;
import nextstep.laddergame.domain.strategy.decorator.LineStrategyRandom;
import nextstep.laddergame.ui.InputView;
import nextstep.laddergame.ui.OutputView;

public class ApplicationGame {

  public static void main(String[] args) {
    Members members = InputView.inputMembers();
    LadderInfo ladderInfo = InputView.inputLadderHeight(members.getSize());
    LineStrategy lineStrategy = new LineStrategyRandom(new LineStrategyNotTwoWay());
    Ladder ladder = ladderInfo.generateLadder(lineStrategy);

    OutputView.printResult(members, ladder);
  }
}
