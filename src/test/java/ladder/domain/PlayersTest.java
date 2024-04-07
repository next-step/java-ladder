package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PlayersTest {
  @Test
  void 정상_생성() {
    Players players = new Players(List.of(
            Player.of("TEST1", 0),
            Player.of("TEST2", 1)
    ));

    Assertions.assertThat(players.values())
            .extracting("name")
            .containsExactly(Name.of("TEST1"), Name.of("TEST2"));
  }
}
