package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {

  public static List<Horizon> generate(int countOfPerson) {
    List<Horizon> ladder = new ArrayList<>();
    for (int i = 0; i <= countOfPerson; i++) {
      ladder.add(new Horizon(countOfPerson));
    }
    return ladder;
  }
}
