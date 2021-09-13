package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

  @ParameterizedTest(name = "생성 테스트 : {0}")
  @ValueSource(strings = {"p", "po", "pob", "pobi", "pobi2"})
  void createTest(String value) {

    //when
    Name name = new Name(value);

    //then
    assertThat(name.getValue()).isEqualTo(value);
  }

  @ParameterizedTest(name = "잘못된 생성 테스트 : {0}")
  @ValueSource(strings = {"", "123456", "1234567"})
  void invalidCreateTest(String value) {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Name(value);
    });
  }
}
