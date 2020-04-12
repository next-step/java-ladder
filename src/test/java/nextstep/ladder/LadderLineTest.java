package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderLineTest {

  @DisplayName("Test for valid LadderLine")
  @Test
  public void testLadderLine() {
    int ladderWidth = 5;
    LadderLine ladderLine = new LadderLine(ladderWidth);

    List<Position> positions = IntStream.range(0, ladderWidth)
        .mapToObj(Position::at)
        .collect(Collectors.toList());

    positions.forEach(position -> {
      Position moved = ladderLine.move(position);
      assertThat(moved.isAdjacent(position)).isTrue();
      assertThat(ladderLine.move(moved)).isEqualTo(position);
    });
  }
}
