package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

  private final List<Position> positions;

  public Line(List<Position> positions) {
    this.positions = positions;
  }

  public static Line from(int numberOfPlayers, PointStrategy strategy) {
    List<Position> positions = new ArrayList<>();
    positions.add(firstPosition(strategy));
    for (int i = 1; i < numberOfPlayers - 1; i++) {
      positions.add(bodyPosition(i, positions.get(i - 1), strategy));
    }
    positions.add(lastPosition(numberOfPlayers - 1, positions.get(positions.size() - 1)));
    return from(positions);
  }

  public static Line from(List<Position> points) {
    return new Line(points);
  }

  private static Position firstPosition(PointStrategy strategy) {
    return Position.of(0, Point.of(false, strategy.linkable()));
  }

  private static Position bodyPosition(int position, Position prev, PointStrategy strategy) {
    return Position.of(position, point(prev, strategy.linkable()));
  }

  private static Position lastPosition(int position, Position prev) {
    return Position.of(position, Point.of(prev.current(), false));
  }

  private static Point point(Position prev, boolean current) {
    if (prev.current() == current) {
      return Point.of(prev.current(), false);
    }
    return Point.of(prev.current(), current);
  }

  public int move(int startPoint) {
    return positions.get(startPoint).move();
  }

  public List<Position> positions() {
    return Collections.unmodifiableList(positions);
  }

}
