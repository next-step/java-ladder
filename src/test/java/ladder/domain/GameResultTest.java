package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.security.InvalidParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameResultTest {

  @ParameterizedTest
  @DisplayName("게임 결과 입력을 통해 게임 결과가 잘 생성되는지 확인")
  @ValueSource(strings = {"꽝", "1000", "2000", "3000"})
  void from(String result) {
    assertThat(GameResult.from(result)).usingRecursiveComparison()
        .isEqualTo(GameResult.from(result));
  }

  @Test
  @DisplayName("비어있는 게임 결과일 경우 에러")
  void exception() {
    assertThatThrownBy(() -> GameResult.from("")).isInstanceOf(InvalidParameterException.class);
  }

}