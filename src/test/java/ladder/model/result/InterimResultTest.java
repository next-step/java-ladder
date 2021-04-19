package ladder.model.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class InterimResultTest {

  @Test
  @DisplayName("생성 테스트")
  void creatingTest() {
    int firstIndex = 0;
    int lastIndex = 0;

    InterimResult interimResult = new InterimResult(0, 0);

    assertThat(interimResult.firstIndex()).isEqualTo(firstIndex);
    assertThat(interimResult.resultIndex()).isEqualTo(lastIndex);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  @DisplayName("이동 테스트")
  void movingTest(int num) {
    InterimResult result = new InterimResult(0, 0);
    result.move(num);
    assertThat(result.resultIndex()).isEqualTo(num);
  }

}
