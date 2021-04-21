package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

  @Test
  @DisplayName("게임 결과를 반환한다.")
  void create() {
    // given
    final Person person = Person.valueOf("dion");
    final Result result = new Result("1000");

    // when
    final GameResult gameResult = GameResult.of(person, result);

    // then
    assertThat(gameResult).isEqualTo(GameResult.of(person, result));
  }
}
