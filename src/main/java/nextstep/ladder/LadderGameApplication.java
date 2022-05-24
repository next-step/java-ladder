package nextstep.ladder;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;

public class LadderGameApplication {

  public static void main(String[] args) {
    Ladder ladder = new Ladder(5, 4);
    List<Line> lines = ladder.lines();
    lines.forEach(line -> {
      System.out.print("     |");
      line.points()
          .forEach(point -> {
            if (Boolean.TRUE.equals(point)) {
              System.out.print("-----|");
              return;
            }
            System.out.print("     |");
          });
      System.out.println();
    });
  }
}
