package ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import ladder.domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

  @Test
  @DisplayName("Ladder 생성 확인")
  public void create() {
    Ladder ladder = new Ladder(5,4);
    assertThat(ladder.size()).isEqualTo(5);
  }

}
