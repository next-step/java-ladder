package ladder.domain;

import ladder.rule.LineRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RecordTest {

  @Test
  @DisplayName("사다리 결과 도메인 생성, 초기 인덱스 값은 각 Player의 인덱스와 동일하다.")
  void generate() {
    // given
    Players players = Players.create("gmoon, guest, test");

    // when
    Record actual = Record.generate(players);

    // then
    assertAll(() -> assertThat(actual.get(Player.create("gmoon"))).isEqualTo(0),
            () -> assertThat(actual.get(Player.create("guest"))).isEqualTo(1),
            () -> assertThat(actual.get(Player.create("test"))).isEqualTo(2));
  }

  @ParameterizedTest
  @MethodSource("runArgument")
  @DisplayName("사다리 결과 기록 테스트, 참고 LineRule.drawing() true, false를 반환한다.")
  void valueOf(int height, int indexOfFirstPlayer, int indexOfSecondPlayer) {
    // given
    Players players = Players.create("gmoon, guest, test");

    // when
    Record actual = Record.generate(players)
            .valueOf(Ladder.generate(height, players.totalSize() - 1, LineRule.drawing()));

    // then
    assertAll(
            () -> assertThat(actual.get(Player.create("gmoon"))).isEqualTo(indexOfFirstPlayer),
            () -> assertThat(actual.get(Player.create("guest"))).isEqualTo(indexOfSecondPlayer),
            () -> assertThat(actual.get(Player.create("test"))).isEqualTo(2)
    );
  }

  static Stream<Arguments> runArgument() {
    return Stream.of(
            Arguments.of(1, 1, 0),
            Arguments.of(2, 0, 1),
            Arguments.of(3, 1, 0)
    );
  }
}