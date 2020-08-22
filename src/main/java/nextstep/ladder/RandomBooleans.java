package nextstep.ladder;

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
    if (countOfSide == 2) {
      return Arrays.asList(true);
    }
    if (countOfSide == 3) {
      return Arrays.asList(true);
    }

    return null;
  }
}
