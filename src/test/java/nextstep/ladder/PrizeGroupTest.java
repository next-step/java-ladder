package nextstep.ladder;

import nextstep.ladder.domain.entity.Names;
import nextstep.ladder.domain.entity.PrizeGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrizeGroupTest {

  @ParameterizedTest
  @ValueSource(strings = {"꽝,5000,꽝,3000"})
  @DisplayName("실행결과를 문자열로 주어 생성한다.")
  void createTest(String input) {
    PrizeGroup prizeGroup = new PrizeGroup(input);

    String[] splitNames = input.split(",");

    Arrays.stream(splitNames)
          .forEach(name -> assertTrue(prizeGroup.stream().anyMatch(prize -> prize.getRank().equals(name))));
  }

  @ParameterizedTest
  @CsvSource(value = {"pobi,honux,crong,jk:꽝,5000,꽝", "pobi,honux:꽝,5000,꽝,3000", "pobi:꽝,5000"}, delimiter = ':')
  @DisplayName("실행결과를 처음 주어진 이름만큼 생성하지 않을 경우 exception을 던진다.")
  void createInvalidCountOfPrizeGroup(String nameList, String prizeList) {
    Names names = new Names(nameList);

    assertThrows(IllegalArgumentException.class, () -> new PrizeGroup(prizeList, names));
  }



}