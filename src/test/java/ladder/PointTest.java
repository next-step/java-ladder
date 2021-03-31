package ladder;

import ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PointTest {

  @Test
  @DisplayName("채워져있는 point인지, 비어있는 point인지 확인")
  public void isUsed() {
    Point usedPoint = new Point(true);
    assertThat(usedPoint.isUsed()).isEqualTo(true);
    Point notUsedPoint = new Point(false);
    assertThat(notUsedPoint.isUsed()).isEqualTo(false);
  }

}
