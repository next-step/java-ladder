package ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderResultTest {

  @Test
  public void 생성테스트() {
    String results = "꽝,5000,꽝,3000";
    LadderResult ladderResult = new LadderResult(results, 4);
  }

  @ParameterizedTest
  @NullSource
  @ValueSource(strings = {"", " "})
  public void 빈값은_실행결과가_될수없다(String results) {
    assertThatThrownBy(() -> {
      LadderResult ladderResult = new LadderResult(results, 1);
    }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("실행결과를 입력하세요");

  }

  @Test
  public void 실행결과는_최소_2개이다() {
    assertThatThrownBy(() -> {
      LadderResult ladderResult = new LadderResult("꽝", 1);
    }).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("실행결과 는 최소 2개입니다.");
  }

  @Test
  public void 결과를_포맷으로_가지고온다() {
    String results = "꽝,5000,꽝,3000";
    String result = "꽝     5000  꽝     3000  ";
    assertThat(new LadderResult(results, 4).toString()).isEqualTo(result);
  }

}
