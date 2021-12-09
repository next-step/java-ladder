package nextstep.ladder;

import nextstep.ladder.domain.entity.Ladder;
import nextstep.ladder.domain.entity.LadderHeight;
import nextstep.ladder.domain.entity.Names;
import nextstep.ladder.domain.service.LadderService;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.view.ViewImpl;

public class LadderApplication {

  public static void main(String[] args) {
    ViewImpl view = new ViewImpl(InputView.getInstance(), ResultView.getInstance());

    Names names = view.getNames();
    LadderHeight ladderHeight = view.getLadderHeight();

    LadderService ladderService = new LadderService();
    Ladder ladder = ladderService.createLadder(ladderHeight, names);

    view.printResult(names, ladder);
  }

}
