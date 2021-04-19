package ladder.model.result;

import ladder.error.NotFoundResultException;
import ladder.model.member.Player;
import ladder.model.prize.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LadderTotalResultsTest {
  Player player;
  Prize prize;

  @BeforeEach
  void setup() {
    player = new Player("꽉");
    prize = new Prize("꽝");
  }

  @Test
  @DisplayName("생성 테스트")
  void createTest() {
    LadderTotalResult result = new LadderTotalResult(player, prize);
    List<LadderTotalResult> ladderTotalResultList = new ArrayList<>();
    ladderTotalResultList.add(result);

    LadderTotalResults results = new LadderTotalResults(ladderTotalResultList);
    Assertions.assertThat(results.findByPlayer(player)).isEqualTo(result);

  }

  @Test
  @DisplayName("찾는 대상 없을 때 에러 테스트")
  void invalidPlayerTest() {

    String invalidPlayerName = "꽐";
    Player invalidPlayer = new Player(invalidPlayerName);

    LadderTotalResult result = new LadderTotalResult(player, prize);
    List<LadderTotalResult> ladderTotalResultList = new ArrayList<>();
    ladderTotalResultList.add(result);

    LadderTotalResults results = new LadderTotalResults(ladderTotalResultList);

    Assertions.assertThatThrownBy(() -> results.findByPlayer(invalidPlayer)).isInstanceOf(NotFoundResultException.class).hasMessage("결과를 찾을 수 없습니다.");

  }

}
