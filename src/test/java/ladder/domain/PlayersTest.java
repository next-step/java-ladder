package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PlayersTest {
  @Test
  void 정상_생성() {
    Players players = Players.from(List.of("TEST1", "TEST2"));

    Assertions.assertThat(players.values())
            .extracting("name")
            .containsExactly(Name.of("TEST1"), Name.of("TEST2"));
  }
}
