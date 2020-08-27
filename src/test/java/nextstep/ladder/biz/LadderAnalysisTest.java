package nextstep.ladder.biz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderAnalysisTest {

  @DisplayName("|        |")
  @Test
  void chopsticks2X1() {
    Ladder ladder = new Ladder(
        Arrays.asList(new Line(Arrays.asList(Point.of(false, 0))))
    );
    LadderAnalysis analysis = new LadderAnalysis(ladder);

    locationStat(analysis, Chessmen.location(0), Chessmen.location(0));
    locationStat(analysis, Chessmen.location(1), Chessmen.location(1));
  }

  @DisplayName("|--------|")
  @Test
  void bridge2X1() {
    Ladder ladder = new Ladder(
        Arrays.asList(new Line(Arrays.asList(Point.of(true, 0))))
    );
    LadderAnalysis analysis = new LadderAnalysis(ladder);

    locationStat(analysis, Chessmen.location(0), Chessmen.location(1));
    locationStat(analysis, Chessmen.location(1), Chessmen.location(0));
  }

  @Test
  void chopsticks2X2() {
    Ladder ladder = new Ladder(
        Arrays.asList(
            new Line(Arrays.asList(Point.of(false, 0))),
            new Line(Arrays.asList(Point.of(false, 0)))
        )
    );
    LadderAnalysis analysis = new LadderAnalysis(ladder);

    locationStat(analysis, Chessmen.location(0), Chessmen.location(0));
    locationStat(analysis, Chessmen.location(1), Chessmen.location(1));
  }

  @Test
  void bridgeIsOne2X2() {
    Ladder ladder = new Ladder(
        Arrays.asList(
            new Line(Arrays.asList(Point.of(true, 0))),
            new Line(Arrays.asList(Point.of(false, 0)))
        )
    );
    LadderAnalysis analysis = new LadderAnalysis(ladder);

    locationStat(analysis, Chessmen.location(0), Chessmen.location(1));
    locationStat(analysis, Chessmen.location(1), Chessmen.location(0));
  }

  /**
   * |---|   |
   * |   |---|
   */
  @Test
  void perBridgeIsOne3X2() {
    Ladder ladder = new Ladder(
        Arrays.asList(
            new Line(Arrays.asList(Point.of(true, 0), Point.of(false, 1))),
            new Line(Arrays.asList(Point.of(false, 0), Point.of(true, 1)))
        )
    );
    LadderAnalysis analysis = new LadderAnalysis(ladder);

    locationStat(analysis, Chessmen.location(0), Chessmen.location(2));
    locationStat(analysis, Chessmen.location(1), Chessmen.location(0));
    locationStat(analysis, Chessmen.location(2), Chessmen.location(1));
  }

  void locationStat(LadderAnalysis analysis, Chessmen chessmen, Chessmen expect) {
    analysis.stat(chessmen);
    assertThat(chessmen).isEqualTo(expect);
  }
}
