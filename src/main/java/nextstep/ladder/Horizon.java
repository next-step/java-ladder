package nextstep.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Horizon {

  private final List<String> points;

  public Horizon(List<String> points) {
    this.points = points;
  }

  public Horizon(int countOfPerson) {
    points = new ArrayList<>();
    for (int i = 0; i < countOfPoint(countOfPerson); i++) {
      points.add(point(i));
    }
  }

  private static int countOfPoint(int countOfPerson) {
    return countOfPerson + (countOfPerson - 1);
  }

  private static String point(int position) {
    return position % 2 == 0
        ? "|"
        : "---------";
  }

  public List<String> getPoints() {
    return Collections.unmodifiableList(points);
  }

  public static Horizon of(List<String> points) {
    return new Horizon(points);
  }
}
