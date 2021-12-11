package domain;

import domain.strategy.HorizontalLineDrawingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Floor {

  private List<Point> points = new ArrayList();

  public Floor(int playersAmount, HorizontalLineDrawingStrategy strategy) {
    makePoints(playersAmount, strategy);
  }

  private void makePoints(int playersAmount, HorizontalLineDrawingStrategy strategy) {
    points.add(new Point(strategy));
    for (int i = 1; i < playersAmount - 1; i++) {
      points.add(new Point(points.get(points.size() - 1).isHasHorizontalLine(), strategy));
    }
  }

  public List<Point> getPoints() {
    return new ArrayList(this.points);
  }

}
