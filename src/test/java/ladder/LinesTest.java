package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinesTest {

  Lines lines;

  @BeforeEach
  public void setup() {
    int lineHeight = 6;
    Players players = new Players("lee,chang,jun");
    lines = new Lines(new LadderGameInformation(players,lineHeight));
  }

  @Test
  public void 생성된_라인수_테스트() {
    assertThat(lines.getHeight()).isEqualTo(6);
  }

}
