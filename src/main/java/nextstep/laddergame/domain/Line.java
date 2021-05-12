package nextstep.laddergame.domain;

import java.util.List;
import java.util.Random;
import nextstep.laddergame.LineGenerator;

public class Line {
  private static final Random RANDOM = new Random();
  private final List<Point> points;

  public Line(List<Point> points) {
    validateCountOfMembers(points.size());
    this.points = points;
  }

  public static Line createLine(int countOfMembers) {
    return new LineGenerator(countOfMembers).generate(RANDOM::nextBoolean);
  }

  private static void validateCountOfMembers(int sizeOfPoints) {
    if(sizeOfPoints <= 0) {
      throw new IllegalArgumentException("ERROR : 0 혹은 0 보다 낮은 수를 입력할 수 없습니다.");
    }
  }

  public List<Point> points() {
    return this.points;
  }

  public int size() {
    return points.size();
  }

  public int next(int index) {
    return move(index);
  }

  private int move(int index) {
    if (points.size() != index)
      return points.get(index).move();
    return points.get(index-1).last().move();
  }

  @Override
  public String toString() {
    return "Line{" +
        "points=" + points +
        '}';
  }
}
