package step2.model.name;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NamesTest {

  @ParameterizedTest
  @ValueSource(strings = {"vat, set, add"})
  @DisplayName("생성 가능한 이름들 공백 붙여 테스트")
  void validNameTest(String inputNames){
    Names names = Names.initNames(inputNames);

//    Assertions.assertThat(inputNames).contains()
  }
}