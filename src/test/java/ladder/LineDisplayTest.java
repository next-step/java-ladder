package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LineDisplayTest {

  @Test
  public void 라인을_그린다() {
    List<Boolean> positions = Arrays.asList(true,false,false);
    LineDisplay lineDisplay = new LineDisplay(positions);

    assertThat(lineDisplay.draw()).isEqualTo("|-----|     |     |");
  }

}