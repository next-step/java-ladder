package ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

  private final List<LinePoint> points;

  // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
  public Line (int countOfPerson) {
    this.points = IntStream.range(0, countOfPerson)
        .mapToObj(i -> new LinePoint(false))
        .collect(Collectors.toList());
  }

  public List<LinePoint> getPoints() {
    return points;
  }

  @Override
  public String toString() {
    return points.stream()
        .map(LinePoint::toString)
        .collect(Collectors.joining());
  }
}
