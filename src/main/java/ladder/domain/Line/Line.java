package ladder.domain.Line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import utils.ListUtils;

public class Line {

  private final List<LinePoint> points;

  // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
  public Line (int countOfPerson) {
    this.points = initAllPointsWithNotConnected(countOfPerson);
  }

  public List<LinePoint> getPoints() {
    return points;
  }

  public void connectRight(int linePointIdx) {
    throwIfLinePointIndexOutOfBound(linePointIdx);
    LinePoint linePoint = points.get(linePointIdx);
  }

  private void throwIfLinePointIndexOutOfBound(int linePointIdx) {
    if (ListUtils.hasElementAt(this.points, linePointIdx)) {
//      throw
    };
  }

  private List<LinePoint> initAllPointsWithNotConnected(int countOfPerson) {
    return IntStream.range(0, countOfPerson)
        .mapToObj(i -> new LinePoint(false))
        .collect(Collectors.toList());
  }

  @Override
  public String toString() {
    return points.stream()
        .map(LinePoint::toString)
        .collect(Collectors.joining());
  }
}
