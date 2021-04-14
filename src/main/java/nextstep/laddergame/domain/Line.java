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
}
