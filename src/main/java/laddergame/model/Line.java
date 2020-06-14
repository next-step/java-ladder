package laddergame.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
  public static Line createByCountOfPerson(PositiveNumber countOfPerson) {
    return new Line(
        Stream.iterate(new Point(false), Point::createNonDuplicatedRungWith)
            .limit(countOfPerson.getValue())
            .collect(Collectors.toList()));
  }

  public List<Point> getPoints() {
    return Collections.unmodifiableList(points);
  }

  public boolean leftPointHasRung(Position position) {
    return points.get(position.getValue()).isRungCreated();
  }

  public boolean rightPointHasRung(Position position) {
    if (position.getValue() < points.size() - 1) {
      return points.get(position.getValue() + 1).isRungCreated();
    }

    return false;
  }

  @Override
  public String toString() {
    return points.stream()
        .map(Point::toString)
        .reduce("", String::concat);
  }
}
