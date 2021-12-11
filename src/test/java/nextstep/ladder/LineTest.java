package nextstep.ladder;

import nextstep.ladder.domain.entity.Line;
import nextstep.ladder.domain.entity.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.IntStream;

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

  List<Point> createPoints(int size) {
    return IntStream.range(0, size)
                    .mapToObj(index -> new Point())
                    .collect(toList());
  }

}