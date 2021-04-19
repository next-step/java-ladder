package ladder.model.result;

import ladder.model.member.Player;
import ladder.model.prize.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTotalResultTest {

  @Test
  @DisplayName("생성 테스트")
  void createTest() {
    String playerName = "꽉";
    String prizeName = "꽝";

    Player player = new Player(playerName);
    Prize prize = new Prize(prizeName);

    LadderTotalResult result = new LadderTotalResult(player, prize);

    Assertions.assertThat(result.player().name()).isEqualTo(playerName);
    Assertions.assertThat(result.prize().prize()).isEqualTo(prizeName);
  }

}
