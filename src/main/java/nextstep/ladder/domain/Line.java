package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

  public static final int MOVE_LENGTH = 1;
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

  private void addPoint(boolean line) {
    points.add(line);
  }

  private boolean isLine(int index, LineStrategy lineStrategy) {
    boolean isFirstPosition = index == 0;
    boolean isAlreadyLinedLeftSide = points.get(index - 1);
    if (isFirstPosition || isAlreadyLinedLeftSide) {
      return false;
    }
    return lineStrategy.isLine();
  }

  public List<Boolean> getPoints() {
    return points;
  }

  public int move(int position) {
    Boolean movableLeft = points.get(position - 1);
    if (movableLeft) {
      return position - MOVE_LENGTH;
    }

    boolean movableRight = points.size() != position && points.get(position);
    if (movableRight) {
      return position + MOVE_LENGTH;
    }

    return position;
  }

}
