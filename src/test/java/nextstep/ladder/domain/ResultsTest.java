package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ResultsTest {

  @DisplayName("입력된 실행결과들을 쉼표(,) 구분하여 생성")
  @ParameterizedTest
  @ValueSource(strings = {"꽝,5000,꽝,3000", "꽝, 5000, 꽝, 3000"})
  void createResults_ShouldBeCreated(String input) {
    assertThat(Results.create(input)).isEqualTo(Results.create(input));
  }

  @Test
  @DisplayName("포인트로 실행결과 찾기")
  void result() {
    Results results = new Results(Results.create("꽝,5000,꽝,3000"));
    assertThat(results.result(1)).isEqualTo(new Result("5000"));
  }
}
