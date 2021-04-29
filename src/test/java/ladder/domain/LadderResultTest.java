package ladder.domain;

import ladder.rule.LineRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderResultTest {

  @Test
  @DisplayName("사다리 결과 도메인 생성, 초기 인덱스 값은 각 Player의 인덱스와 동일하다.")
  void generate() {
    // given
    Players players = Players.create("gmoon, guest, test");

    // when
    LadderResult actual = LadderResult.generate(players);

    // then
    assertAll(() -> assertThat(actual.get(Player.create("gmoon"))).isEqualTo(0),
            () -> assertThat(actual.get(Player.create("guest"))).isEqualTo(1),
            () -> assertThat(actual.get(Player.create("test"))).isEqualTo(2));
  }

  @Test
  @DisplayName("사다리 결과 테스트, 참고 LineRule.drawing() true, false를 반환한다.")
  void run() {
    // given
    Players players = Players.create("gmoon, guest, test");
    LadderResult ladderResult = LadderResult.generate(players);

    // when
    LadderResult actual = ladderResult.run(Ladder.generate(1, players.totalSize() - 1, LineRule.drawing()));

    // then
    assertAll(
            () -> assertThat(actual.get(Player.create("gmoon"))).isEqualTo(1),
            () -> assertThat(actual.get(Player.create("guest"))).isEqualTo(0),
            () -> assertThat(actual.get(Player.create("test"))).isEqualTo(2)
    );
  }
}