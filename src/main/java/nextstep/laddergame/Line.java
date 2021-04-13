package nextstep.laddergame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import nextstep.laddergame.util.LineGenerator;

public class Line {
  private List<Boolean> points = new ArrayList<>();

  public Line(List<Boolean> points) {
    this.points = points;
  }

  public static Line createLine(int countOfPerson) {
    return new LineGenerator()
        .generate(countOfPerson);
  }

  @Override
  public String toString() {
    //TODO 테스트용 메서드이므로 추후에 Ladder에서 갖고 있는 Line을 통해서 points 값을 접근하게끔 처리할 예정
    return points.stream()
        .map(Objects::toString)
        .collect(Collectors.joining(", "));
  }
}
