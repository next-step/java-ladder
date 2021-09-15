package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LineTest {

  @Test
  @DisplayName("생성 테스트")
  void createTest() {
    //given
    List<Boolean> points = Arrays.asList(false, true, false, true, false);

    //when
    Line line = new Line(points);

    //then
    assertThat(line.getSize()).isEqualTo(points.size());
    for (int i = 0; i < line.getSize(); i++) {
      assertThat(line.isExistFoothold(i)).isEqualTo(points.get(i));
    }
  }

  @Test
  @DisplayName("잘못된 생성 테스트")
  void invalidCreateTest() {
    //given
    List<Boolean> points1 = Arrays.asList(true, false, false, true, false);  // 처음부터 발판 존재
    List<Boolean> points2 = Arrays.asList(false, false, true, true, false);  // 연속된 발판

    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Line(points1);
    });
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Line(points2);
    });
  }

  @Test
  @DisplayName("주어진 크기에 해당하는 랜덤Line 생성 테스트")
  void randomLineTest() {
    //given
    int size = 5;

    //when
    Line line = Line.randomLine(size);

    //then
    assertThat(line.getSize()).isEqualTo(size);
  }

  @ParameterizedTest(name = "다음 위치 반환 테스트")
  @CsvSource(
      value = {"false,true,false,true,false|1,0,3,2,4",
          "false,false,false,true|0,1,3,2",
          "false|0"},
      delimiter = '|'
  )
  void getMovablePositionTest(String pointsStr, String resultStr) {
    //given
    List<Boolean> points = Arrays.stream(pointsStr.split(","))
        .map(Boolean::valueOf).collect(Collectors.toList());
    List<Integer> result = Arrays.stream(resultStr.split(","))
        .map(Integer::valueOf).collect(Collectors.toList());

    //when
    Line line = new Line(points);

    //then
    for (int i = 0; i < points.size(); i++){
      assertThat(line.getMovablePosition(i)).isEqualTo(result.get(i));
    }
  }
}
