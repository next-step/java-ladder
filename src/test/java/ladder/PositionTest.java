package ladder;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ladder.domain.Point;
import ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

  @Test
  @DisplayName("rightMove 확인")
  public void rightMove() {
    Position position = new Position(0);
    assertThat(position.rightMove()).isEqualTo(new Position(1));
  }

  @Test
  @DisplayName("leftMove 확인")
  public void leftMove() {
    Position position = new Position(1);
    assertThat(position.leftMove()).isEqualTo(new Position(0));
  }

  @Test
  @DisplayName("isRightMove 확인")
  public void isRightMove() {

    List<Boolean> tmp = Arrays.asList(false,true,false,true);
    List<Point> points= new ArrayList<>();
    for (int i = 0; i< 4; i++) {
      points.add(new Point(tmp.get(i)));
    }

    Position position = new Position(0);
    assertThat(position.isRightMove(points)).isEqualTo(true);
  }

  @Test
  @DisplayName("isLeftMove 확인")
  public void isLeftMove() {

    List<Boolean> tmp = Arrays.asList(false,true,false,true);
    List<Point> points= new ArrayList<>();
    for (int i = 0; i< 4; i++) {
      points.add(new Point(tmp.get(i)));
    }

    Position position = new Position(0);
    assertThat(position.isLeftMove(points)).isEqualTo(false);
  }

}
