package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder.domain.dimension.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {

  @Test
  @DisplayName("Bridge가 없는 Point 인스턴스를 생성한다")
  void createTrueInstance() {
    Point point = Point.of(Boolean.TRUE);
    assertThat(point.isNotBridge()).isFalse();
  }

  @Test
  @DisplayName("Bridge가 없는 Point 인스턴스를 생성한다")
  void createFalseInstance() {
    Point point = Point.of(Boolean.FALSE);
    assertThat(point.isNotBridge()).isTrue();
  }

}
