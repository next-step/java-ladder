package nextstep.laddergame.domain;

import java.util.List;
import java.util.Random;
import nextstep.laddergame.LineGenerator;

public class Line {
  private static final Random RANDOM = new Random();
  private final List<Boolean> points;

  public Line(List<Boolean> points) {
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

  public List<Boolean> points() {
    return this.points;
  }

  public int size() {
    return points.size();
  }

  public int next(int index) {
    return move(index);
  }

  private int move(int index) {
    if(isFirst(index) && !(isLast(index)))
      return hasNextPoint(index);
    if(!isFirst(index) && isLast(index))
      return hasPreviousPoint(index);
    if(!isFirst(index) && !isLast(index))
      return hasNextOrPreviousPoint(index);

    return index;
  }

  private int hasNextOrPreviousPoint(int index) {
    if(points.get(index -1)) {
      return --index;
    } else if(points.get(index)){
      return ++index;
    }
    return index;
  }

  private int hasNextPoint(int index) {
    if(points.get(index)) {
      return ++index;
    }
    return index;
  }

  private int hasPreviousPoint(int index) {
    if(points.get(index - 1)) {
      return --index;
    }
    return index;
  }

  private boolean isFirst(int index) {
    return index == 0;
  }

  private boolean isLast(int index) {
    return points.size() == index;
  }
}
