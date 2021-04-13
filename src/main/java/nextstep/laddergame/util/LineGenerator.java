package nextstep.laddergame.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LineGenerator extends Random {

  private static final Random RANDOM = new Random();

  private LineGenerator() {

  }

  public static List<Boolean> createLine(int countOfMembers, DrawStrategy strategy) {
    List<Boolean> points = new ArrayList<>();

    IntStream.range(0, countOfMembers)
        .mapToObj(index -> drawLine(isRowContinuousTrue(points, index), strategy))
        .forEach(points::add);

    return points;
  }

  public static List<Boolean> generate(int countOfMembers) {
    return createLine(countOfMembers, RANDOM::nextBoolean);
  }

  private static boolean isRowContinuousTrue(List<Boolean> points, int index) {
    return index != 0 && points.get(index - 1);
  }

  private static boolean drawLine(Boolean isRowContinuous, DrawStrategy strategy) {
    if (isRowContinuous) {
      return false;
    }
    return strategy.isLine();
  }
}
