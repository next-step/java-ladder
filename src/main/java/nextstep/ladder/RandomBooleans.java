package nextstep.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomBooleans {
  private static final Random random = new Random();

  public static boolean nextBoolean(boolean previous) {
    if (previous) {
      return false;
    }
    return random.nextBoolean();
  }

  public static List<Boolean> form(int countOfPerson) {
    int countOfSide = countOfPerson - 1;
    if (countOfSide == 1) {
      return Arrays.asList(true);
    }
    List<Boolean> bridges = new ArrayList<>();
    boolean previous = false;
    for (int i = 0; i < countOfSide; i++) {
      previous = nextBoolean(previous);
      bridges.add(previous);
    }

    oneIsTrue(bridges);

    return bridges;
  }

  public static void oneIsTrue(List<Boolean> bridges) {
    if (bridges.stream().allMatch(b -> b == false)) {
      int index = random.ints(0, bridges.size())
          .findFirst().getAsInt();

      System.out.println(index);

      bridges.set(index, true);
    }
  }
}
