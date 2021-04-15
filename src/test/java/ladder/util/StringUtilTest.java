package ladder.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("null or 빈 문자열일 경우 true 반환")
  void isBlank(String blankString) {
    // given

    // when
    boolean isBlank = StringUtil.isBlank(blankString);

    // then
    assertThat(isBlank).isTrue();
  }
}