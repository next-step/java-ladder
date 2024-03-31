package ladder.domain;

import ladder.domain.strtegy.BooleanRandomLineGenerator;
import ladder.domain.strtegy.LineGenerateStrategy;

import java.util.*;

public class LadderGame {

  private static final int START_LADDER_HEIGHT_INDEX = 1;

  private final List<User> users;
  private final Map<LadderHeight, LadderLine> lineMap;

  private LadderGame(List<User> users, Map<LadderHeight, LadderLine> lineMap) {
    this.users = users;
    this.lineMap = lineMap;
  }

  public static LadderGame start(List<User> users, LadderHeight ladderHeight) {
    Map<LadderHeight, LadderLine> initMap = new HashMap<>();
    LineGenerateStrategy generator = new BooleanRandomLineGenerator();

    for (int i = START_LADDER_HEIGHT_INDEX; i <= ladderHeight.height(); i++) {
      initMap.put(new LadderHeight(i), generator.generate(users.size() - 1));
    }

    return new LadderGame(users, initMap);
  }

  public boolean isSameLadderHeight(int height) {
    return lineMap.size() == height;
  }
}
