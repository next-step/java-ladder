package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("이름 래퍼 클래스 생성 테스트, null or 빈 문자열인 경우 이셉션을 발생한다.")
  void ofBlankSafeWithCheckLength_blankString(String actual) {
    // given
    int maxLength = 5;

    // when

    // then
    assertThatIllegalArgumentException()
            .isThrownBy(() -> Name.ofBlankSafeWithCheckLength(actual, maxLength));
  }

  @RepeatedTest(100)
  @DisplayName("이름 래퍼 클래스 생성 테스트, 허용된 길이가 초과되면 이셉션을 발생한다.")
  void ofBlankSafeWithCheckLength_invalidLength() {
    // given
    int maxLength = 5;

    // when
    String actual = generatedRandomString(maxLength + 1);

    // then
    assertThatIllegalArgumentException()
            .isThrownBy(() -> Name.ofBlankSafeWithCheckLength(actual, maxLength));
  }

  String generatedRandomString(int targetLength) {
    return new Random().ints('a', 'z' + 1)
            .limit(targetLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
  }
}