package ladder.domain.ladder;

import config.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGeneratorTest extends BaseTest {

  private LadderGenerator ladderGenerator;

  @BeforeEach
  void setup() {
    ladderGenerator = new DefaultLadderGenerator();
  }


  @Test
  @DisplayName("LadderGenerator | 사다리에서 인접한 포인트들은 연속으로 이어질 수 없다.")
  void test() {
    // given

  }
}
