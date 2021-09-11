package nextstep.step2;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import nextstep.step2.domain.GameParticipants;
import nextstep.step2.domain.LadderGameEngine;
import nextstep.step2.domain.LadderGameResult;
import nextstep.step2.domain.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameEngine {

  int ladderHeight;
  String participants;
  List<Line> lines;

  @BeforeEach
  void setUp() {
    ladderHeight = 5;
    participants = "pobi,honux,crong,jk";

    lines = new ArrayList<>();
    for (int i = 0; i < participants.split(",").length; i++) {
      lines.add(new Line(Arrays.asList(false, false, false, false)));
    }
  }

  @ParameterizedTest
  @ValueSource(strings = {"꽝,5000,꽝,3000"})
  void Ladder_게임결과_테스트(String ladderGameResultStr) {

    GameParticipants gameParticipants = new GameParticipants(participants);

    LadderGameEngine ladderGameEngine = new LadderGameEngine(gameParticipants, lines,
        ladderGameResultStr);
    LadderGameResult ladderGameResult = ladderGameEngine.execute();

    for (int i = 0; i < gameParticipants.getParticipantsSize(); i++) {
      String gameResult = ladderGameResult
          .getLadderGameResult(gameParticipants.getGameParticipants(i));
      assertThat(gameResult)
          .isEqualTo(ladderGameResult.getLadderGameResult(gameParticipants.getGameParticipants(i)));
    }
  }

}
