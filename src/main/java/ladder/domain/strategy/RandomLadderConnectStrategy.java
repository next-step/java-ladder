package ladder.domain.strategy;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLadderConnectStrategy implements LadderConnectStrategy {

  private static final String INVALID_LINE_WIDTH_MSG = "사다리의 길이는 1 이상이어야 합니다";
  private static final String INVALID_HEIGHT_MSG = "사다리의 높이는 1 이상이어야 합니다";
  private final List<List<Boolean>> connects;
  private final Random random;

  public RandomLadderConnectStrategy(int height, int width) {
    assertRandomLadderConnectStrategy(height, width);
    this.random = new Random();
    connects = new ArrayList<>();
    for (int i = 0; i < height; i++) {
      connects.add(makeLineConnects(width));
    }
  }

  private List<Boolean> makeLineConnects(int width) {
    ArrayList<Boolean> lineConnects = new ArrayList<Boolean>();
    boolean lastConnect = false;
    for (int j = 0; j < width - 1; j++) {
      boolean connect = isCurrentConnect(random.nextBoolean(), lastConnect);
      lineConnects.add(connect);
      lastConnect = connect;
    }
    lineConnects.add(false);
    return lineConnects;
  }

  private void assertRandomLadderConnectStrategy(int height, int width) {
    if (height <= 0) {
      throw new InvalidParameterException(INVALID_HEIGHT_MSG);
    }
    if (width < 0) {
      throw new InvalidParameterException(INVALID_LINE_WIDTH_MSG);
    }
  }

  private boolean isCurrentConnect(boolean currConnect, boolean lastConnect) {
    if (lastConnect) {
      return false;
    }
    return currConnect;
  }

  @Override
  public List<Boolean> create(int height) {
    return connects.get(height);
  }
}
