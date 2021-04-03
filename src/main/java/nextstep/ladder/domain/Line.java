package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {

  private static final Random RANDOM = new Random();
  private List<Boolean> points = new ArrayList<>();

  public Line() {
  }

  public static Line generate(int countOfPerson, LineStrategy lineStrategy) {
    Line line = new Line();
    IntStream.range(0, countOfPerson)
        .mapToObj(i -> line.isLine(i, lineStrategy))
        .forEach(line::addPoint);
    return line;
  }

  public static Line generate(int countOfPerson) {
    return generate(countOfPerson, () -> RANDOM.nextBoolean());
  }

  private void addPoint(boolean line) {
    points.add(line);
  }

  private boolean isLine(int index, LineStrategy lineStrategy) {
    if (index == 0 || points.get(index - 1)) {
      return false;
    }
    return lineStrategy.isLine();
  }

  public List<Boolean> getPoints() {
    return points;
  }

}
