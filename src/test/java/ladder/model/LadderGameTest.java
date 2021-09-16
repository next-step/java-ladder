package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {

  @Test
  @DisplayName("생성테스트")
  void createTest() {
    //given
    String participants = "pobi,honux,crong,jk";
    String results = "꽝,5000,꽝,3000";
    LadderGameInfo ladderGameInfo = new LadderGameInfo(participants, results);

    List<LadderLine> ladderLines = new ArrayList<>();
    ladderLines.add(new LadderLine(Arrays.asList(false, true, false, true)));
    ladderLines.add(new LadderLine(Arrays.asList(false, false, true, false)));
    Ladder ladder = new Ladder(ladderLines);

    //when
    LadderGame ladderGame = new LadderGame(ladderGameInfo, ladder);

    //then
    assertThat(ladderGame.getLadderWidth()).isEqualTo(4);
    assertThat(ladderGame.getLadderHeight()).isEqualTo(2);
    assertThat(ladderGame.getParticipants()).containsExactly("pobi", "honux", "crong", "jk");
    assertThat(ladderGame.getResults()).containsExactly("꽝", "5000", "꽝", "3000");
  }

  @Test
  @DisplayName("생성테스트")
  void invalidCreateTest() {
    //given
    String participants = "pobi,honux,crong,jk";
    String results = "꽝,5000,꽝,3000";
    LadderGameInfo ladderGameInfo = new LadderGameInfo(participants, results);

    List<LadderLine> ladderLines = new ArrayList<>();
    ladderLines.add(new LadderLine(Arrays.asList(false, true, false)));
    ladderLines.add(new LadderLine(Arrays.asList(false, false, true)));
    Ladder ladder = new Ladder(ladderLines);

    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LadderGame(ladderGameInfo, ladder);
    });
  }
}
