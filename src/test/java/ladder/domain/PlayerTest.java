package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
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
    final boolean validName = Player.MAX_VALUE_LENGTH >= name.length();

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

  static Stream<Arguments> playerNameArguments() {
    return Stream.of(
            Arguments.of("gmoon"),
            Arguments.of("123456")
    );
  }

}
