package laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NaturalNumberTest {

  @ParameterizedTest
  @CsvSource({
      "-1"
  })
  @DisplayName("0보다 작은 경우")
  void init_expectedThrowIllegalArgumentException(int value) {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
      new NaturalNumber(value);
    });
  }

  @ParameterizedTest
  @CsvSource({
      "0",
      "1"
  })
  void getValue(int value) {
    assertThat(new NaturalNumber(value)).isEqualTo(new NaturalNumber(value));
  }
}