package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LineDisplayTest {

  @Test
  public void 라인을_그린다() {
    List<Point> positions = Arrays.asList(new Point(Direction.RIGHT), new Point(Direction.LEFT),
        new Point(Direction.STRAIGHT), new Point(Direction.STRAIGHT));
    LineDisplay lineDisplay = new LineDisplay(positions);

    assertThat(lineDisplay.draw()).isEqualTo("|-----|     |     |");
  }

}