package nextstep.ladder.biz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineAnalysisTest {

  @DisplayName("|        |")
  @Test
  void chopsticks() {
    Line line = new Line(Arrays.asList(Point.of(false, 0)));
    LineAnalysis analysis = new LineAnalysis(line);

    locationStat(analysis, Chessmen.location(0), Chessmen.location(0));
    locationStat(analysis, Chessmen.location(1), Chessmen.location(1));
  }

  @DisplayName("|--------|")
  @Test
  void bridge() {
    Line line = new Line(Arrays.asList(Point.of(true, 0)));
    LineAnalysis analysis = new LineAnalysis(line);

    locationStat(analysis, Chessmen.location(0), Chessmen.location(1));
    locationStat(analysis, Chessmen.location(1), Chessmen.location(0));
  }

  @DisplayName("|--------|        |")
  @Test
  void bridgeWithPier() {
    Line line = new Line(Arrays.asList(Point.of(true, 0), Point.of(false, 1)));
    LineAnalysis analysis = new LineAnalysis(line);

    locationStat(analysis, Chessmen.location(0), Chessmen.location(1));
    locationStat(analysis, Chessmen.location(1), Chessmen.location(0));
    locationStat(analysis, Chessmen.location(2), Chessmen.location(2));
  }


  @DisplayName("|        |--------|")
  @Test
  void pierWithBridgeWith() {
    Line line = new Line(Arrays.asList(Point.of(false, 0), Point.of(true, 1)));
    LineAnalysis analysis = new LineAnalysis(line);

    locationStat(analysis, Chessmen.location(0), Chessmen.location(0));
    locationStat(analysis, Chessmen.location(1), Chessmen.location(2));
    locationStat(analysis, Chessmen.location(2), Chessmen.location(1));
  }

  @DisplayName("|--------|        |--------|")
  @Test
  void bridgeWithPierWithBridge() {
    Line line = new Line(Arrays.asList(
        Point.of(true, 0),
        Point.of(false, 1),
        Point.of(true, 2)));
    LineAnalysis analysis = new LineAnalysis(line);

    locationStat(analysis, Chessmen.location(0), Chessmen.location(1));
    locationStat(analysis, Chessmen.location(1), Chessmen.location(0));
    locationStat(analysis, Chessmen.location(2), Chessmen.location(3));
    locationStat(analysis, Chessmen.location(3), Chessmen.location(2));
  }

  void locationStat(LineAnalysis analysis, Chessmen chessmen, Chessmen expect) {
    analysis.stat(chessmen);
    assertThat(chessmen).isEqualTo(expect);
  }
}
