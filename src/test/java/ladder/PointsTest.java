package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PointsTest {

  @Test
  public void 생성테스트() {
    int playerCount = 5;
    Points points = new Points(playerCount);
    assertThat(points.count()).isEqualTo(playerCount);
  }

}