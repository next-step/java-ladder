package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderLineTest {

  private LadderLine ladderLine;

  @BeforeEach
  public void setUp() {
    ladderLine = LadderLine.createPoints(4, () -> true);
  }

  @Test
  public void create_Line() {
    List<Point> points = ladderLine.points();

    assertAll(
            () -> assertThat(points.get(0).canMovePrevious()).isFalse(),
            () -> assertThat(points.get(0).canMoveNext()).isTrue(),
            () -> assertThat(points.get(1).canMovePrevious()).isTrue(),
            () -> assertThat(points.get(1).canMoveNext()).isFalse(),
            () -> assertThat(points.get(2).canMovePrevious()).isFalse(),
            () -> assertThat(points.get(2).canMoveNext()).isTrue(),
            () -> assertThat(points.get(3).canMovePrevious()).isTrue(),
            () -> assertThat(points.get(3).canMoveNext()).isFalse()
    );
  }
}
