package ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import ladder.domain.Line;
import ladder.domain.Lines;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinesTest {

  @Test
  @DisplayName("Lines 생성 확인")
  public void create() {
    Lines lines = new Lines(5,4);
    assertThat(lines.size()).isEqualTo(5);
  }

}
