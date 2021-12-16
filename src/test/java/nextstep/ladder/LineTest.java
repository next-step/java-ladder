package nextstep.ladder;

import nextstep.ladder.domain.entity.Line;
import nextstep.ladder.domain.entity.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LineTest {

  @ParameterizedTest
  @ValueSource(ints = {5, 11, 6})
  @DisplayName("사다리를 생성하기 위해 사람의 숫자만큼 사다리를 생성한다.")
  void create(int countOfPerson) {
    List<Point> points = createPoints(countOfPerson);
    Line line = new Line(points);

    assertEquals(countOfPerson, line.size());
  }

  @ParameterizedTest
  @CsvSource(value = {"1:2", "2:1", "3:4", "4:3"}, delimiter = ':')
  @DisplayName("길과 시작점이 주어졌을 때 도착 지점을 반환한다.")
  void moveTest(int startingPoint, int result) {
    // way : |-| |-|
    Line line = createLine(Arrays.asList(false, true, false, true, false));

    int endPoint = line.move(startingPoint);
    assertEquals(result, endPoint);
  }

  private List<Point> createPoints(int size) {
    return IntStream.range(0, size)
                    .mapToObj(index -> new Point())
                    .collect(toList());
  }

  private Line createLine(List<Boolean> booleanList) {
    return booleanList.stream()
                      .map(Point::new)
                      .collect(collectingAndThen(toList(), Line::new));
  }

}