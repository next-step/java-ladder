package domain;

import java.util.List;
import java.util.stream.IntStream;

public class Line {

  private Points points;

  public Line(int countOfPerson) {

    points = new Points();
    IntStream.range(0, countOfPerson)
        .forEach(count -> points.add());
  }

  public List<Point> getPoints() {
    return points.gets();
  }

  public int move(int position) {
    return points.move(position);
  }
}
