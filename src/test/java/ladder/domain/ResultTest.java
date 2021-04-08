package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

  @Test
  @DisplayName("[Result] Result 생성 테스트")
  void resultTest() {
    Result result = new Result("5000");

    assertThat(result).isEqualTo(new Result("5000"));
  }

}
