package ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import ladder.domain.Line;
import ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

  @Test
  @DisplayName("init 확인")
  public void init() {
    int sizeOfPerson = 5;
    System.out.println(Line.init(sizeOfPerson));
  }

  @Test
  @DisplayName("line 움직임 확인")
  public void move() {
    Line line = Line.init(2);
    System.out.println("ladder result : " + line.move(new Position(0)));
  }
}
