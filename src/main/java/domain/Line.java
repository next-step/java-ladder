package domain;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {

  private ArrayList<Boolean> points = new ArrayList<>();

  public Line(int countOfPerson) {

    IntStream.range(0, countOfPerson)
        .forEach(count -> points.add(hasPoint(count)));
  }

  private boolean hasPoint(int count) {

    if (count == 0) {
      return false;
    }

    if (points.get(count - 1)) {
      return false;
    }

    return new Random().nextBoolean();
  }

  public ArrayList<Boolean> getPoints() {
    return points;
  }
}
