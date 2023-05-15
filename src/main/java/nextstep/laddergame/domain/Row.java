package nextstep.laddergame.domain;

import java.util.List;

public class Row {

  private List<Point> points;

  public Row(List<Point> points, Members members) {
    if (!members.equalsSize(points.size())) {
      throw new IllegalArgumentException("Row는 입력받은 멤버수 만큼의 Point를 가져야합니다.");
    }

    this.points = points;
  }
}
