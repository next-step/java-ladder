package nextstep.ladder;

import nextstep.ladder.domain.entity.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PrizeTest {

  @ParameterizedTest
  @ValueSource(strings = {"꽝","5000","꽝","3000"})
  @DisplayName("수행 결과를 문자열 형태로 주어 생성한다.")
  void create(String input) {
    Prize prize = new Prize(input);

    assertEquals(input, prize.getRank());
  }

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("null 이나 비어있는 값을 생성자의 인자로 줄 경우 exception을 던진다.")
  void createInvalidInput(String input) {
    assertThrows(IllegalArgumentException.class, () -> new Prize(input));
  }

}
