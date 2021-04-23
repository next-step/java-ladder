package nextstep.laddergame;

import java.io.IOException;
import java.util.Locale;
import nextstep.laddergame.domain.Award;
import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.LadderBoard;
import nextstep.laddergame.domain.Members;
import nextstep.laddergame.domain.Name;
import nextstep.laddergame.ui.InputView;
import nextstep.laddergame.ui.OutputView;

public class LadderController {

  private static final String FIND_ALL = "all";

  public LadderController() throws IOException {
    LadderBoard ladderBoard = initPhase();
    ladderPrintPhase(ladderBoard);
    ladderResultPhase(ladderBoard);
  }

  public static void startLadderGame() throws IOException {
    new LadderController();
  }

  private LadderBoard initPhase() throws IOException {
    Members members = getMembers();
    Award award = getAward(members.size());
    Ladder ladder = getLadder(members);
    return new LadderBoard(ladder, award);
  }

  private void ladderPrintPhase(LadderBoard ladderBoard) {
    new OutputView().printLadder(ladderBoard.ladder(),
        ladderBoard.award());
  }

  private void ladderResultPhase(LadderBoard ladderBoard) throws IOException {
    repeatablePrintLadderResult(ladderBoard);
  }

  private void repeatablePrintLadderResult(LadderBoard ladderBoard) throws IOException {
    while (true) {
        Name targetMember = findTargetName();
        if (isAll(targetMember)) {
          new OutputView().printAllLadderResult(ladderBoard);
          break;
        }
        new OutputView().printLadderResult(targetMember, ladderBoard);
    }
  }

  private boolean isAll(Name targetMember) {
    return targetMember.name()
        .toLowerCase(Locale.ROOT)
        .equals(FIND_ALL);
  }

  private Name findTargetName() throws IOException {
    return new InputView().enteredFindResult();
  }

  private Ladder getLadder(Members members) throws IOException {
    return Ladder.createLadder(getLadderHeight(), members);
  }

  private int getLadderHeight() throws IOException {
    return new InputView().enteredLadderHeight();
  }

  private Members getMembers() throws IOException {
    return new InputView().enteredUserNames();
  }

  private Award getAward(int size) throws IOException {
    return new InputView().enteredAward(size);
  }
}
