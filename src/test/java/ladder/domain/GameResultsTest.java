package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.security.InvalidParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class GameResultsTest {

  @ParameterizedTest
  @DisplayName("결과 입력을 통해 결과 입력들이 잘 만들어지는지 확인")
  @ValueSource(strings = {"꽝,5000,꽝,3000", "꽝,꽝", "100,200", "100,꽝,꽝,100000"})
  void from(String results) {
    assertThat(GameResults.from(results)).usingRecursiveComparison()
        .isEqualTo(GameResults.from(results));
  }

  @ParameterizedTest
  @DisplayName("잘못된 결과 입력은 에러 발생 확인")
  @ValueSource(strings = {"", ",1,,", ",100,",})
  void exception(String results) {
    assertThatThrownBy(() -> GameResults.from(results)).isInstanceOf(
        InvalidParameterException.class);
  }

  @ParameterizedTest
  @DisplayName("결과 입력들의 개수가 정확한지 확인")
  @CsvSource(value = {"꽝,5000,꽝,3000|4", "꽝,꽝|2", "100,200|2", "100,꽝,꽝,100000|4"}, delimiter = '|')
  void size(String results, int size) {
    assertThat(GameResults.from(results).getResultSize()).isEqualTo(size);
  }
}
