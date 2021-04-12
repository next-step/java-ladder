package nextstep.ladder.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ResultsTest {

  @Test
  @DisplayName("결과 배열을 받아 Results 객체를 생성한다.")
  void generate() {
    String[] names = {"1", "2", "3"};
    Results results = Results.generate(names);
    assertEquals(results.size(), names.length);
  }

  @ParameterizedTest
  @CsvSource(value = {"0,1", "1,2", "2,3"})
  @DisplayName("인덱스 번호로 결과를 찾는다.")
  void findResult(int index, String expected) {
    String[] names = {"1", "2", "3"};
    Results results = Results.generate(names);
    Result result = results.findResult(index);
    assertEquals(result.getName(), expected);
  }

}