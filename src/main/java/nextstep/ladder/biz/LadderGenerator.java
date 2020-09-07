package nextstep.ladder.biz;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {

  public static Ladder generate(int countOfPerson, int ladderHeight) {
    List<Line> lines = new ArrayList<>();
    for (int i = 0; i < ladderHeight; i++) {
      lines.add(new Line(countOfPerson));
    }
    return new Ladder(lines);
  }

  public static Ladder2 generate2(int countOfPerson, int ladderHeight) {
    List<LadderLine> lines = new ArrayList<>();
    for (int i = 0; i < ladderHeight; i++) {
      LadderLine init = LadderLine.init(countOfPerson);
      System.out.println(init);
      lines.add(init);
    }
    return new Ladder2(lines);
  }

}
