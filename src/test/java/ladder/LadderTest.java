package ladder;

import ladder.domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

  @Test
  @DisplayName("Ladder 생성 확인")
  public void create() {
    Ladder ladder = new Ladder(1, 2);
    System.out.println(ladder);
  }

}
