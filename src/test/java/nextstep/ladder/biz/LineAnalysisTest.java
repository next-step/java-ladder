package nextstep.ladder.biz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineAnalysisTest {

  @DisplayName("|        |")
  @Test
  void chopsticks() {
    Line line = new Line(Arrays.asList(Point.of(false)));

    LineAnalysis analysis = new LineAnalysis(line);
    assertThat(analysis.stat(0)).isEqualTo(0);
    assertThat(analysis.stat(1)).isEqualTo(1);
  }

  @DisplayName("|--------|")
  @Test
  void bridge() {
    Line line = new Line(Arrays.asList(Point.of(true, 0)));

    LineAnalysis analysis = new LineAnalysis(line);
    assertThat(analysis.stat(0)).isEqualTo(1);
    assertThat(analysis.stat(1)).isEqualTo(0);
  }

  @DisplayName("|--------|        |")
  @Test
  void bridgeWithPier() {
    Line line = new Line(Arrays.asList(Point.of(true, 0), Point.of(false, 1)));

    LineAnalysis analysis = new LineAnalysis(line);
    assertThat(analysis.stat(0)).isEqualTo(1);
    assertThat(analysis.stat(1)).isEqualTo(0);
    assertThat(analysis.stat(2)).isEqualTo(2);
  }

  @DisplayName("|--------|        |--------|")
  @Test
  void bridgeWithPierWithBridge() {
    Line line = new Line(Arrays.asList(
        Point.of(true, 0),
        Point.of(false, 1),
        Point.of(true, 2)));

    LineAnalysis analysis = new LineAnalysis(line);
    assertThat(analysis.stat(0)).isEqualTo(1);
    assertThat(analysis.stat(1)).isEqualTo(0);
    assertThat(analysis.stat(2)).isEqualTo(3);
    assertThat(analysis.stat(3)).isEqualTo(2);
  }
}
