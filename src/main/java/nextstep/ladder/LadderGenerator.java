package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {

  public static List<Horizon> generate(Players players) {
    List<Horizon> ladder = new ArrayList<>();
    for (int i = 0; i < players.getLadderHeight(); i++) {
      ladder.add(new Horizon(players.countOfPerson()));
    }
    return ladder;
  }
}
