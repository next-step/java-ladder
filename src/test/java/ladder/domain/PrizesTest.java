package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PrizesTest {
  @Test
  void n번_라인의_상품() {
    Prizes prizes = new Prizes(List.of(new Prize("1000"), new Prize("꽝"), new Prize("10000")));
    assertThat(prizes.prizeAt(1)).isEqualTo(new Prize("꽝"));
  }
}
