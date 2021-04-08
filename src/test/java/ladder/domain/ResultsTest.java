package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultsTest {

  @Test
  @DisplayName("[Results] 실행 결과 조회 테스트")
  void gameResultTest() {
    String player = "crong";
    Results results = new Results(Arrays.asList(new Result("당첨"), new Result("꽝")));

    results.put(new Name(player), 0);
    String result = results.findOne(player);

    assertThat(result).isEqualTo("당첨");
  }
}
