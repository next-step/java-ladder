package ladder.domain;

import ladder.domain.player.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest {

  @ParameterizedTest(name = "LadderPlayer | 사다리게임 참가자 이름은 5글자를 초과 할 수 없다. {0}")
  @ValueSource(strings = {"브루스윌리스", "도널드 트럼프"})
  void 사다리게임_참가_유저의_이름은_최대_5글자(String given) {
     // when & then
    Assertions.assertThatThrownBy(() -> new Player(given))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
