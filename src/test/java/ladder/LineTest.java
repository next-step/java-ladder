package ladder;

import static java.util.Collections.emptyList;
import static ladder.LineIndexTest.FIRST_LINE_INDEX;
import static ladder.LineIndexTest.SECOND_LINE_INDEX;
import static ladder.LineIndexTest.THIRD_LINE_INDEX;
import static ladder.PlayersTest.PLAYERS_1;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class LineTest {

  private static final List<Boolean> POINTS = List.of(true, false, false, true, false);
  public static final Line LINE_1 = new Line(POINTS);
  public static final Line LINE_2 = new Line(List.of(true, false, false, true, false));

  @Test
  void Line_생성_성공() {
    assertDoesNotThrow(() -> new Line(POINTS));
  }

  @Test
  void Line_생성_실패() {
    assertThrows(IllegalArgumentException.class, () -> new Line(emptyList()));
  }

  @Test
  void points_성공() {
    List<Boolean> points = LINE_1.points();
    assertThat(points).isEqualTo(POINTS);
  }

  @Test
  void playerNumber_성공() {
    assertThat(LINE_1.playerNumber()).isEqualTo(POINTS.size());
  }

  @Test
  void nextIndex_오른쪽으로_이동_성공() {
    assertThat(LINE_1.nextIndex(FIRST_LINE_INDEX)).isEqualTo(SECOND_LINE_INDEX);
  }

  @Test
  void nextIndex_왼쪽으로_이동_성공() {
    assertThat(LINE_1.nextIndex(SECOND_LINE_INDEX)).isEqualTo(FIRST_LINE_INDEX);
  }

  @Test
  void nextIndex_이동하지않음_성공() {
    assertThat(LINE_1.nextIndex(THIRD_LINE_INDEX)).isEqualTo(THIRD_LINE_INDEX);
  }

  @Test
  void from_성공() {
    Line line = Line.from(PLAYERS_1);
    assertThat(line.playerNumber()).isEqualTo(PLAYERS_1.sizeOfPlayers());
  }
}
