package ladder.step3.domain;

import ladder.step3.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class LadderGameTest {

  @DisplayName("사다리의 결과를 확인하는 테스트")
  @Test
  void 사다리_게임_테스트 () {
    Participants participants = Participants.of("aa,bb,cc,dd");
    LadderResults ladderResults = LadderResults.of("1,2,3,4", participants);
    LadderHeight ladderHeight = LadderHeight.valueOf(3);
    Ladder ladder = Ladder.of(participants, ladderHeight, prev -> !prev);
    ResultView.getInstance().viewLadder(ladder, participants, ladderResults);
    System.out.println("");
    LadderGame ladderGame = LadderGame.of(
      LadderGameExecutor.execute(participants, ladderResults, ladder.shape())
    );
    ResultView.getInstance().viewAllResult(ladderGame, participants);
  }
}
