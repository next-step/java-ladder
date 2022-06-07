package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LadderLineTest {

  @Test
  void init() {
    LadderLine ladderLine = LadderLine.init(10);
    assertThat(ladderLine.size()).isEqualTo(10);
  }
}
