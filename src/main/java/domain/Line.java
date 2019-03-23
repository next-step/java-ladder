package domain;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {

  private ArrayList<Boolean> points = new ArrayList<>();

  public Line(int countOfPerson) {

    IntStream.range(0, countOfPerson)
        .mapToObj(this::hasPoint)
        .forEach(point -> points.add(point));
  }

  private boolean hasPoint(int count) {
    if (count == 0) {
      return false;
    }
    return new Random().nextBoolean();
  }

  public ArrayList<Boolean> getPoints() {
    return points;
  }
}
