package ladder.domain;

import ladder.exception.PlayerNameBlankException;
import ladder.exception.PlayerNameOverLimitLengthException;
import ladder.util.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NameTest {

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("이름 래퍼 클래스 생성 테스트, null or 빈 문자열인 경우 이셉션을 발생한다.")
  void ofBlankSafeWithCheckLength_blankString(String actual) {
    // given
    int maxLength = 5;

    // when

    // then
    assertThatExceptionOfType(PlayerNameBlankException.class)
            .isThrownBy(() -> Name.ofBlankSafeWithCheckLength(actual, maxLength))
            .withMessageMatching("이름은 null 또는 빈 문자열을 입력할 수 없습니다.");
  }

  @RepeatedTest(100)
  @DisplayName("이름 래퍼 클래스 생성 테스트, 허용된 길이가 초과되면 이셉션을 발생한다.")
  void ofBlankSafeWithCheckLength_invalidLength() {
    // given
    int maxLength = 5;

    // when
    String actual = StringUtil.generatedRandomString(maxLength + 1);

    // then
    assertThatExceptionOfType(PlayerNameOverLimitLengthException.class)
            .isThrownBy(() -> Name.ofBlankSafeWithCheckLength(actual, maxLength))
            .withMessageMatching("이름 길이가 \\d+ 초과했습니다.");
  }

}