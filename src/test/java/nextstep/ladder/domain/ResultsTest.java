package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsTest {

  @DisplayName("정적 팩터리 메서드로 Results를 생성한다.")
  @Test
  void createByFactoryMethod() {
    int playerSize = 4;
    List<String> values = List.of("꽝", "5000", "꽝", "3000");

    Results results = Results.of(values, playerSize);

    assertThat(results).isNotNull().isInstanceOf(Results.class);
  }

  @DisplayName("playerSize와 입력값 리스트의 사이즈가 일치하지 않으면 예외를 던진다.")
  @Test
  void createWithValidation() {
    int playerSize = 5;
    List<String> values = List.of("꽝", "5000", "꽝", "3000");

    assertThatThrownBy(() -> Results.of(values, playerSize))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
