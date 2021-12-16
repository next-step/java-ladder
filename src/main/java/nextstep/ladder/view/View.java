package nextstep.ladder.view;

import nextstep.ladder.domain.entity.Ladder;
import nextstep.ladder.domain.entity.LadderHeight;
import nextstep.ladder.domain.entity.Names;
import nextstep.ladder.domain.entity.PrizeEntry;
import nextstep.ladder.domain.entity.PrizeGroup;

public interface View {

  Names getNames();

  PrizeGroup getResults(Names names);

  String getTarget();

  LadderHeight getLadderHeight();

  void printLadder(Names names, Ladder ladder);

  void printPrize(PrizeGroup prizeGroup);

  void printResult(PrizeEntry entry, PrizeGroup prizeGroup);
}
