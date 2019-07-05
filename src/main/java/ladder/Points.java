package ladder;

import java.util.ArrayList;
import java.util.List;

public class Points {

  List<Point> points = new ArrayList<>();

  public Points(int playerCount) {
    makeLine(playerCount);
  }

  public Points(List<Point> points) {
    this.points = points;
  }

  private void makeLine(int playersCount) {
    firstPositionMakeBar();
    for (int i = 1; i < playersCount - 1; i++) {
      bodyPointMake(i);
    }
    lastPointMake();
  }

  private void firstPositionMakeBar() {
    points.add(new Point(DirectionMaker.make()));
  }

  private void bodyPointMake(int index) {
    if (getPoint(index - 1).hasLine()) {
      points.add(new Point(Direction.LEFT));
      return;
    }
    points.add(new Point(DirectionMaker.make()));
  }

  private void lastPointMake() {
    if (getPoint(count()-1).hasLine()) {
      points.add(new Point(Direction.LEFT));
      return;
    }
    points.add(new Point(Direction.STRAIGHT));
  }

  public LineDisplay draw() {
    return new LineDisplay(points);
  }

  public int count() {
    return points.size();
  }

  public int move(int index) {
    return getPoint(index).move(index);
  }

  private Point getPoint(int index) {
    return points.get(index);
  }

}
