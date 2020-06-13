package laddergame.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositiveNumberTest {

  @ParameterizedTest
  @CsvSource({
      "-1",
      "0"
  })
  @DisplayName("1보다 작은 경우")
  void init_expectedThrowIllegalArgumentException(int value) {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
      new PositiveNumber(value);
    });
  }

  @ParameterizedTest
  @CsvSource({
      "3",
      "1"
  })
  void getValue(int value) {
    assertThat(new PositiveNumber(value)).isEqualTo(new PositiveNumber(value));
  }
}