package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ResultTest {

  @Test
  void generate() {
    String name = "꽝";
    Result result = Result.generate(name);
    assertEquals(result.getName(), name);
  }

  @Test
  void generate_fail_over_length() {
    String name ="꽝입니다요.";
    assertThatIllegalArgumentException()
        .isThrownBy(() -> Result.generate(name))
        .withMessage("name.length < 6");
  }

}
