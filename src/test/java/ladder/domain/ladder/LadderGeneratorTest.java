package ladder.domain.ladder;

import org.junit.jupiter.api.BeforeEach;

public class LadderGeneratorTest {

  private LadderGenerator ladderGenerator;

  @BeforeEach
  void setup() {
    ladderGenerator = new DefaultLadderGenerator();
  }
}
