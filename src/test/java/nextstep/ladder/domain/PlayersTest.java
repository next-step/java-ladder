package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayersTest {

  @DisplayName("입력된 플레이어 이름들을 ,(콤마) 구분하여 플레이어 생성")
  @ParameterizedTest
  @ValueSource(strings = {"apple,tesla,tsmc,meta", "apple, tesla, tsmc, meta"})
  void givenPlayerNames_ShouldBeCreated(String input) {
    assertThat(Players.create(input)).isEqualTo(Players.create(input));
  }
}
