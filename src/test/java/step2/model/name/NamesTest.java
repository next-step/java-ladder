package step2.model.name;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NamesTest {

  @ParameterizedTest
  @CsvSource(value = {"vat, set, add:set"}, delimiter = ':')
  @DisplayName("생성 가능한 이름들 공백 붙여 테스트")
  void validNameTest(String inputNames, String testName) {
    Names names = Names.initNames(inputNames);
    Name targetName = new Name(testName);

    Assertions.assertThat(names.isNameContains(targetName)).isTrue();
  }
}