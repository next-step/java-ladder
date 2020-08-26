package nextstep.ladder.biz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LineGenerator {

  public static final int TWO_PERSON = 2;
  private static final Random random = new Random();

  public static List<Point> form(int countOfPerson) {
    if (isTwoPerson(countOfPerson)) {
      return Arrays.asList(nextBoolean(Point.of(false)));
    }

    List<Point> points = createPoints(countOfPerson);
    leastOneIsTrue(points);

    return points;
  }

  private static boolean isTwoPerson(int countOfPerson) {
    return countOfPerson == TWO_PERSON;
  }

  private static List<Point> createPoints(int countOfPerson) {
    int bridgeOfCount = countOfPerson - 1;
    List<Point> line = new ArrayList<>();
    Point previous = Point.of(false);
    for (int i = 0; i < bridgeOfCount; i++) {
      previous = nextBoolean(previous);
      line.add(previous);
    }

    return line;
  }

  static Point nextBoolean(Point previous) {
    if (previous.hasPoint()) {
      return Point.of(false);
    }
    return Point.of(random.nextBoolean());
  }

  static void leastOneIsTrue(List<Point> bridges) {
    if (bridges.stream().noneMatch(b -> b.hasPoint())) {
      int index = random.ints(0, bridges.size())
          .findFirst().getAsInt();
      bridges.set(index, Point.of(true));
    }
  }
}
