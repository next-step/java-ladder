package nextstep.ladder.biz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineAnalysisTest {

  @DisplayName("|        |")
  @Test
  void chopsticks1() {
    Line line = new Line(Arrays.asList(Point.of(false, 0)));

    locationStat(line, Chessmen.location(0), Chessmen.location(0));
    locationStat(line, Chessmen.location(1), Chessmen.location(1));
  }


  @DisplayName("|--------|")
  @Test
  void bridge() {
    Line line = new Line(Arrays.asList(Point.of(true, 0)));

    locationStat(line, Chessmen.location(0), Chessmen.location(1));
    locationStat(line, Chessmen.location(1), Chessmen.location(0));
  }

  @DisplayName("|--------|        |")
  @Test
  void bridgeWithPier() {
    Line line = new Line(Arrays.asList(Point.of(true, 0), Point.of(false, 1)));

    locationStat(line, Chessmen.location(0), Chessmen.location(1));
    locationStat(line, Chessmen.location(1), Chessmen.location(0));
    locationStat(line, Chessmen.location(2), Chessmen.location(2));
  }


  @DisplayName("|        |--------|")
  @Test
  void pierWithBridgeWith() {
    Line line = new Line(Arrays.asList(Point.of(false, 0), Point.of(true, 1)));

    locationStat(line, Chessmen.location(0), Chessmen.location(0));
    locationStat(line, Chessmen.location(1), Chessmen.location(2));
    locationStat(line, Chessmen.location(2), Chessmen.location(1));
  }

  void locationStat(Line line, Chessmen chessmen, Chessmen expect) {
    LineAnalysis.stat(line, chessmen);
    assertThat(chessmen).isEqualTo(expect);
  }

}
