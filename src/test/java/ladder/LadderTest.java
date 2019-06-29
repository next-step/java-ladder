package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LadderTest {

  Ladder ladder;

  @BeforeEach
  public void setup() {
    int lineHeight = 6;
    Players players = new Players("lee,chang,jun");
    ladder = new Ladder(6, players.count());
  }

  @Test
  public void 생성된_라인수_테스트() {
    assertThat(ladder.getHeight()).isEqualTo(6);
  }

}