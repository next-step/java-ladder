package ladder.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

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

  @Test
  @DisplayName("랜덤 문자열을 생성한다.")
  void generatedRandomString() {
    // given
    int targetLength = 4;

    // when
    String randomString = StringUtil.generatedRandomString(targetLength);

    // then
    assertThat(randomString.length())
            .isEqualTo(targetLength);
  }

  @Test
  @DisplayName("null 경우 \"\" 문자열을 반환한다.")
  void defaultString() {
    assertThat(StringUtil.defaultString(null)).isEqualTo("");
  }

  @Test
  @DisplayName("null safe한 trim")
  void trim() {
    assertThat(StringUtil.trim(null)).isEqualTo("");
  }

  @Test
  @DisplayName("문자열을 입력시  list로 반환한다.")
  void toList() {
    // given
    String split = ",";
    String input = "gmoon, dodo";

    // when
    List<String> actual = StringUtil.toList(input);

    // then
    assertThat(actual)
            .isNotEmpty()
            .hasSize(2)
            .contains("gmoon", "dodo");
  }
}