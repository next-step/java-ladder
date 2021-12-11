package nextstep.ladder.view;

import nextstep.ladder.domain.entity.Ladder;
import nextstep.ladder.domain.entity.LadderHeight;
import nextstep.ladder.domain.entity.Names;

public interface View {

  Names getNames();

  LadderHeight getLadderHeight();

  void printResult(Names names, Ladder ladder);
}
