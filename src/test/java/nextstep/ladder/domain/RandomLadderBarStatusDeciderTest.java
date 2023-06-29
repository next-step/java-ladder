package nextstep.ladder.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomLadderBarStatusDeciderTest {

  @Test
  void decide_returnEmptyIfCacheNotEmpty() {
    Assertions.assertThat(new RandomLadderBarStatusDecider().decide(LadderBarStatus.BAR))
        .isEqualTo(LadderBarStatus.EMPTY);
  }

}