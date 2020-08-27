package nextstep.ladder.biz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderAnalysisTest {

  @DisplayName("|        |")
  @Test
  void chopsticks() {
    Ladder ladder = LadderGenerator.generate(2, 1);

    LadderAnalysis analysis = new LadderAnalysis(ladder);
    assertThat(analysis.stat(0)).isEqualTo(0);
    assertThat(analysis.stat(1)).isEqualTo(1);
  }

  @DisplayName("|--------|")
  @Test
  void bridge() {
    Ladder ladder = LadderGenerator.generate(2, 1);

    LadderAnalysis analysis = new LadderAnalysis(ladder);
    assertThat(analysis.stat(0)).isEqualTo(1);
    assertThat(analysis.stat(1)).isEqualTo(0);
  }
}
