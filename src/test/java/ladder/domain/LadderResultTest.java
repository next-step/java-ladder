package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderResultTest {

  @DisplayName("플레이어 숫자와 결과의 개수가 다르면 예외발생")
  @ParameterizedTest
  @ValueSource(ints = {2, 4})
  void validateSize(int size) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> LadderResults.of("test1,test2,test3", size));
  }
}
