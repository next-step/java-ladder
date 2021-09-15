package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderLineTest {

  @Test
  @DisplayName("생성 테스트")
  void createTest() {
    //given
    List<Boolean> points = Arrays.asList(false, true, false, true, false);

    //when
    LadderLine ladderLine = new LadderLine(points);

    //then
    assertThat(ladderLine.getSize()).isEqualTo(points.size());
    for (int i = 0; i < ladderLine.getSize(); i++) {
      assertThat(ladderLine.isExistFoothold(i)).isEqualTo(points.get(i));
    }
  }

  @Test
  @DisplayName("잘못된 생성 테스트")
  void invalidCreateTest() {
    //given
    List<Boolean> points1 = Arrays.asList(true, false, false, true, false);  // 처음부터 발판 존재
    List<Boolean> points2 = Arrays.asList(false, false, true, true, false);  // 연속된 발판
    List<Boolean> points3 = Collections.emptyList();

    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LadderLine(points1);
    });
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LadderLine(points2);
    });
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LadderLine(points3);
    });
  }

  @Test
  @DisplayName("주어진 크기에 해당하는 랜덤Line 생성 테스트")
  void randomLadderLineTest() {
    //given
    int size = 5;

    //when
    LadderLine ladderLine = LadderLine.randomLadderLine(size);

    //then
    assertThat(ladderLine.getSize()).isEqualTo(size);
  }

  @ParameterizedTest(name = "다음 위치 반환 테스트")
  @CsvSource(
      value = {
          "false,true,false,true,false|1,0,3,2,4",
          "false,false,false,true|0,1,3,2",
          "false|0"
      },
      delimiter = '|'
  )
  void nextPositionTest(String pointsStr, String resultStr) {
    //given
    List<Boolean> points = Arrays.stream(pointsStr.split(","))
        .map(Boolean::valueOf).collect(Collectors.toList());
    List<Integer> result = Arrays.stream(resultStr.split(","))
        .map(Integer::valueOf).collect(Collectors.toList());

    //when
    LadderLine ladderLine = new LadderLine(points);

    //then
    for (int i = 0; i < points.size(); i++) {
      assertThat(ladderLine.nextPosition(i)).isEqualTo(result.get(i));
    }
    assertThatIllegalArgumentException().isThrownBy(() -> {
      ladderLine.nextPosition(-1);
    });
    assertThatIllegalArgumentException().isThrownBy(() -> {
      ladderLine.nextPosition(result.size());
    });
  }
}
