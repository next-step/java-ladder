package ladderGame.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LineGenerator {

  public static final int INT_ONE = 1;

  public static List<Boolean> createLine(final int countOfPerson) {

    List<Boolean> lines = new ArrayList<>();

    lines.add(false);

    IntStream.range(INT_ONE, countOfPerson)
        .forEach(person -> lines.add(isHaveNode(lines.get(person - INT_ONE))));

    return lines;
  }

  private static Boolean isHaveNode(final Boolean afterNode) {

    if (afterNode) {
      return false;
    }
    return new Random().nextBoolean();

  }
}