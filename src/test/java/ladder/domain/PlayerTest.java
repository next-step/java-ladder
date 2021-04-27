package ladder.domain;

import ladder.exception.PlayerNameBlankException;
import ladder.exception.PlayerNameOverLimitLengthException;
import ladder.util.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class PlayerTest {

  @ParameterizedTest
  @MethodSource("playerNameArguments")
  @DisplayName("사다리 게임 참가자를 생성한다.")
  void create(String name) {
    // given

    // when
    final boolean validName = Player.MAX_LENGTH >= name.length();

    // then
    assertAll("사다리 게임 참가자를 생성한다.",
            () -> assumingThat(validName,
                    () -> assertThat(Player.create(name))
                            .isEqualTo(Player.create(name))),

            () -> assumingThat(!validName,
                    () -> assertThatIllegalArgumentException()
                            .isThrownBy(() -> Player.create(name))
                            .describedAs("이름은 5자를 초과할 수 없다."))
    );
  }


  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("사다리 게임 참가자 이름은 null or 빈 문자열인 경우 이셉션을 발생한다.")
  void create_error_blank(String actual) {
    assertThatExceptionOfType(PlayerNameBlankException.class)
            .isThrownBy(() -> Player.create(actual))
            .withMessageMatching("이름은 null 또는 빈 문자열을 입력할 수 없습니다.");
  }

  @RepeatedTest(100)
  @DisplayName("사다리 게임 참가자 이름은 길이가 5 초과되면 이셉션을 발생한다.")
  void create_error_name_length() {
    // given
    int maxLength = Player.MAX_LENGTH;

    // when
    String actual = StringUtil.generatedRandomString(maxLength + 1);

    // then
    assertThatExceptionOfType(PlayerNameOverLimitLengthException.class)
            .isThrownBy(() -> Player.create(actual))
            .withMessageMatching("이름 길이가 \\d+ 초과했습니다.");
  }


  static Stream<Arguments> playerNameArguments() {
    return Stream.of(
            Arguments.of("gmoon"),
            Arguments.of("123456")
    );
  }

}
