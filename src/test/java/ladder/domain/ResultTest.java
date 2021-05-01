package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}