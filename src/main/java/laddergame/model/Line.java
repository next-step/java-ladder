package laddergame.model;

import java.util.ArrayList;
import java.util.List;

public class Line {

  private final List<Point> points;

  public Line(List<Point> points) {
    this.points = points;
  }

  /**
   * 인원수에 따라 라인의 포인트 생성(첫 칸은 반드시 false)
   * <p>
   * - 포인트의 가로 라인(사다리 발)은 랜덤 생성
   * <p>
   * - 왼쪽에 가로 라인이 있으면 반드시 가로 라인이 없음
   *
   * @param countOfPerson 게임 참가 인원 수
   * @return 생성된 라인
   */
  public static Line createByCountOfPerson(int countOfPerson) {
    List<Point> points = new ArrayList<>();

    points.add(new Point(false));

    for (int i = 1; i < countOfPerson; i++) {
      points.add(Point.createNonDuplicatedRungWith(points.get(i - 1)));
    }

    return new Line(points);
  }

  public List<Point> getPoints() {
    return new ArrayList<>(points);
  }
}
