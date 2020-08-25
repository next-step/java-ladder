package nextstep.ladder.biz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LineGenerator {

  public static final int TWO_PERSON = 2;
  private static final Random random = new Random();

  public static List<Boolean> form(int countOfPerson) {
    if (isTwoPerson(countOfPerson)) {
      return Arrays.asList(nextBoolean(false));
    }

    List<Boolean> points = createPoints(countOfPerson);
    leastOneIsTrue(points);

    return points;
  }

  private static boolean isTwoPerson(int countOfPerson) {
    return countOfPerson == TWO_PERSON;
  }

  private static List<Boolean> createPoints(int countOfPerson) {
    int bridgeOfCount = countOfPerson - 1;
    List<Boolean> points = new ArrayList<>();
    boolean previous = false;
    for (int i = 0; i < bridgeOfCount; i++) {
      previous = nextBoolean(previous);
      points.add(previous);
    }

    return points;
  }

  static boolean nextBoolean(boolean previous) {
    if (previous) {
      return false;
    }
    return random.nextBoolean();
  }

  static void leastOneIsTrue(List<Boolean> bridges) {
    if (bridges.stream().noneMatch(b -> b)) {
      int index = random.ints(0, bridges.size())
          .findFirst().getAsInt();
      bridges.set(index, true);
    }
  }
}
