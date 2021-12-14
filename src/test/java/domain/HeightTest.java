package domain;

import common.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static common.Constants.MIN_LADDER_HEIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

  @ParameterizedTest
  @MethodSource("heightMethodSource")
  @DisplayName("MIN_LADDER_HEIGHT 보다 크거나 같은 수의 height를 갖는 Height객체가 정상적으로 생성되고, Height객체가 갖는 값이 " +
          "생성자의 파라미터로 주어진 값과 동일한지를 검증하는 테스트")
  void createHeight(int givenHeight) {
    // when
    Height height = new Height(givenHeight);

    // then
    assertThat(height.getValue()).isEqualTo(givenHeight);
  }

  static Stream<Arguments> heightMethodSource() {
    return Stream.of(
            Arguments.of(MIN_LADDER_HEIGHT),
            Arguments.of(MIN_LADDER_HEIGHT + 1)
    );
  }

  @Test
  @DisplayName("MIN_LADDER_HEIGHT 보다 작은 수의 height를 갖는 Height객체는 생성할 수 없음을 검증하는 테스트")
  void heightCannotLowerThanMIN_LADDER_HEIGHT() {
    // given
    int wrongHeight = MIN_LADDER_HEIGHT - 1;

    assertThatThrownBy(() ->
                    // when
                    new Height(wrongHeight)
            // then
    ).isInstanceOf(IllegalArgumentException.class)
            .withFailMessage(ErrorMessages.LADDER_HEIGHT_IS_TOO_SHORT);
  }

}