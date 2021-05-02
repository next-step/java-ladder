package ladder.domain;

import ladder.rule.LineRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ResultTest {

  @Test
  @DisplayName("실행 결과 일급 컬렉션 생성 테스트")
  void generate() {
    // given
    String input = "꽝,5000,꽝,3000";

    // when
    Result result = Result.generate(input);

    // then
    assertThat(result.getValues())
            .hasSize(4)
            .containsExactly("꽝", "5000", "꽝", "3000");
  }

  @Test
  @DisplayName("특정 사용자의 사다리 결과 문자열을 반환한다.")
  void get() {
    // given
    Players players = Players.create("gmoon,test");
    Record record = Record.generate(players, Ladder.generate(1, players.totalSize() - 1, LineRule.drawing()));

    // then
    Result actual = Result.generate("꽝,5000");

    // then
    assertAll(() -> assertThat(actual.get(record, Player.create("gmoon"))).isEqualTo("5000"),
            () -> assertThat(actual.get(record, Player.create("test"))).isEqualTo("꽝"));
  }
}