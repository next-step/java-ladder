package laddergame.model;

import static org.assertj.core.api.Assertions.*;

import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PointTest {

  @ParameterizedTest
  @CsvSource({
      "true",
      "false"
  })
  void isLineCreated(boolean rungCreated) {
    Point point = new Point(rungCreated);

    assertThat(point.isRungCreated()).isEqualTo(rungCreated);
  }

  @Test
  void createNonDuplicatedRungWith() {
    Point pointHasRung = new Point(true);
    Point pointNotHasRung = new Point(false);

    for (int i = 0; i < 1000; i++) {
      assertThat(Point.createNonDuplicatedRungWith(pointHasRung).isRungCreated()).isFalse();
      System.out.print(Point.createNonDuplicatedRungWith(pointNotHasRung).isRungCreated()+"||");
    }
  }
}
