package ladder.domain.core;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class LadderPartLineTest {

  @RepeatedTest(20)
  @DisplayName("라인 width 에 따라 잘 생성되는지 확인")
  void from() {
    int width = new Random().nextInt(100);
    LadderPartLine line = LadderPartLine.from(width);

    assertThat(line.getWidth()).isEqualTo(width);
  }


  @RepeatedTest(20)
  @DisplayName("라인에서 연결된 채로 잘 움직이며 한 칸만 움직이는지 확인")
  void move() {
    int width = new Random().nextInt(100);
    LadderPartLine line = LadderPartLine.from(width);
    List<Integer> moves = new ArrayList<>();

    int move = 0;
    for (int i = 0; i < width; i++) {
      move = line.move(move);
      moves.add(move);
    }

    for (int i = 1; i < moves.size(); i++) {
      int moveSize = Math.abs(moves.get(i) - moves.get(i - 1));
      assertThat(moveSize).isLessThan(2);
    }
  }

}
