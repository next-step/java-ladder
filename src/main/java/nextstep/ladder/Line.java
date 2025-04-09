package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
  private final List<Boolean> points;

  public Line(int count) {
    this.points = generatePoints(count);
  }

  private List<Boolean> generatePoints(int count) {
    List<Boolean> result = new ArrayList<>();
    Random random = new Random();

    for (int i = 0; i < count - 1; i++) {
      result.add(canDrawLine(result, i) && random.nextBoolean());
    }

    return result;
  }

  private boolean canDrawLine(List<Boolean> result, int index) {
    return index == 0 || !result.get(index - 1);
  }

  public List<Boolean> points() {
    return points;
  }

  public int width() {
    return points.size();
  }
}
