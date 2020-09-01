package nextstep.ladder.biz;

import java.util.List;

public class Line {

  private final List<Point> points;

  public Line(int countOfPerson) {
    points = LineGenerator.form(countOfPerson);
  }

  public Line(List<Point> points) {
    this.points = points;
  }

  public List<Point> getPoints() {
    return points;
  }

  public Line selectableLine(Chessmen chessmen) {
    if (chessmen.getLocation() == 0) {
      return new Line(points.subList(0, 1));
    }

    if (chessmen.getLocation() == points.size()) {
      return new Line(points.subList(chessmen.getLocation() - 1, chessmen.getLocation()));
    }

    return new Line(points.subList(chessmen.getLocation() - 1, chessmen.getLocation() + 1));
  }

  public Chessmen cast(Chessmen chessmen) {
    return selectableLine(chessmen).getPoints().stream()
            .filter(Point::hasPoint)
            .findFirst()
            .map(chessmen::move)
            .orElse(chessmen);
  }

  @Override
  public String toString() {
    return "Line{" +
            "points=" + points +
            '}';
  }
}
