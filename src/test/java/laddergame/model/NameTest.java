package laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NameTest {

  @ParameterizedTest
  @CsvSource({
      "test"
  })
  void initName(String nameStr) {
    Name name = new Name(nameStr);

    assertThat(name.toString()).isEqualTo(nameStr);
  }

  @ParameterizedTest
  @CsvSource({
      "testtest"
  })
  void initName_이름5글자초과(String nameStr) {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
      new Name(nameStr);
    });

  }
}