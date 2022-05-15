package ladder.domain.strategy;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLadderConnectStrategy implements LadderConnectStrategy {

  private static final String INVALID_LINE_WIDTH_MSG = "사다리의 너비는 1 이상이어야 합니다";
  private static final String INVALID_HEIGHT_MSG = "사다리의 높이는 1 이상이어야 합니다";
  private final List<List<Boolean>> connects;
  private final Random random;

  public RandomLadderConnectStrategy(int height, int width) {
    assertRandomLadderConnectStrategy(height, width);
    this.random = new Random();

    connects = IntStream.range(0, height)
        .mapToObj(h -> makeLineConnects(width))
        .collect(Collectors.toList());
  }

  private List<Boolean> makeLineConnects(int width) {
    ArrayList<Boolean> lineConnects = new ArrayList<Boolean>();
    boolean lastConnect = false;
    for (int j = 0; j < width - 1; j++) {
      boolean connect = isCurrentConnect(lastConnect);
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

  private boolean isCurrentConnect(boolean lastConnect) {
    if (lastConnect) {
      return false;
    }
    return random.nextBoolean();
  }

  @Override
  public List<Boolean> create(int height) {
    return connects.get(height);
  }
}
