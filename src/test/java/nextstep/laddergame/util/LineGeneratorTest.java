package nextstep.laddergame.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import nextstep.laddergame.LineGenerator;
import nextstep.laddergame.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LineGeneratorTest {

  @ParameterizedTest
  @MethodSource("generateData")
  @DisplayName("랜덤 값이 항상 true일 조건에서 예상된 결과대로 Line이 생성된다")
  public void generateCountOfPerson1(int countOfPerson, List<String> result) throws Exception {
    //given
    Line line = new LineGenerator(countOfPerson).generate(() -> true);
    //when
    //then
    assertArrayEquals(line.line().toArray(), result.toArray());
  }

  static Stream<Arguments> generateData() {
    return Stream.of(
        Arguments.of(1, Arrays.asList(true)),
        Arguments.of(2, Arrays.asList(true, false)),
        Arguments.of(3, Arrays.asList(true, false, true)),
        Arguments.of(4, Arrays.asList(true, false, true, false)),
        Arguments.of(5, Arrays.asList(true, false, true, false, true))
    );
  }
}