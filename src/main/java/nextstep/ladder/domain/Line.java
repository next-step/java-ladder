package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
  private List<Boolean> points;

  public Line(List<Boolean> points) {
    validateNoConsecutiveConnection(points);
    this.points = new ArrayList<>(points);
  }

  private void validateNoConsecutiveConnection(List<Boolean> points) {
    for (int i = 0; i < points.size() - 1; i++) {
      if (points.get(i) && points.get(i + 1)) {
        throw new IllegalArgumentException("연속된 가로선은 허용되지 않습니다.");
      }
    }
  }

  public Line(int countOfPerson) {
    this(generatePoints(countOfPerson));
  }

  private static List<Boolean> generatePoints(int countOfPerson) {
    List<Boolean> points = new ArrayList<>();
    for (int i = 0; i < countOfPerson - 1; i++) {
      points.add(generatePoint(points));
    }
    return points;
  }

  private static boolean generatePoint(List<Boolean> points) {
    if (points.isEmpty()) {
      return Math.random() < 0.5;
    }
    if (points.get(points.size() - 1)) {
      return false;
    }
    return Math.random() < 0.5;
  }

  public boolean hasConnectionAt(int position) {
    return points.get(position);
  }

  public int move(int position) {
    if (position > 0 && points.get(position - 1)) {
      return position - 1;
    }
    if (position < points.size() && points.get(position)) {
      return position + 1;
    }
    return position;
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("     ");
    for(int i = 0; i < points.size(); i++){
      sb.append("|").append(points.get(i)? "-----" : "     ");
    }
    sb.append("|");
    return sb.toString();
  }
}
