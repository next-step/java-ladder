package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class NameTest {

  @ParameterizedTest
  @MethodSource("nameProvider")
  @DisplayName("trim되어서 입력되는지 확인")
  void initName(String nameStr, String expected) {
    Name name = new Name(nameStr);

    assertThat(name.toString()).isEqualTo(expected);
  }

  public static Stream<Arguments> nameProvider() {
    return Stream.of(
      arguments(
          "test",
          "  test"
      ),
        arguments(
            "testt",
            " testt"
        ),
        arguments(
            "t",
            "     t"
        ),
        arguments(
            "te",
            "    te"
        )
    );
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