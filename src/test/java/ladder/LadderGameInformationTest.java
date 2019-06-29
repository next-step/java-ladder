package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LadderGameInformationTest {

  LadderGameInformation information;

  @BeforeEach
  public void setup() {
    Players players = new Players("lee,chang,jun");
    int ladderHeight = 5;
    information = new LadderGameInformation(players, ladderHeight);
  }

  @Test
  public void 플레이어수를_구해온다() {
    assertThat(information.playersCount()).isEqualTo(3);
  }

  @Test
  public void 사다리높이를_구해온다() {
    assertThat(information.ladderHeight()).isEqualTo(5);
  }

}
