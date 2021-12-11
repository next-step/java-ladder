package domain;

import domain.strategy.HorizontalLineDrawingStrategy;

public class Point {

  private boolean hasHorizontalLine;

  public Point(HorizontalLineDrawingStrategy strategy) {
    this.hasHorizontalLine = strategy.draw();
  }

  public Point(boolean previousPointHasHorizontalLine, HorizontalLineDrawingStrategy strategy) {
    this.hasHorizontalLine = previousPointHasHorizontalLine ? false : strategy.draw();
  }

  public boolean isHasHorizontalLine() {
    return hasHorizontalLine;
  }

}
