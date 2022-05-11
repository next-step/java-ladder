package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.security.InvalidParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserNameTest {

  @ParameterizedTest
  @DisplayName("사용자 이름을 잘 생성하는지 확인")
  @ValueSource(strings = {"pobi", "hihi", "next", "crong"})
  void of(String name) {
    assertThat(UserName.of(name)).usingRecursiveComparison().isEqualTo(UserName.of(name));
  }

  @ParameterizedTest
  @DisplayName("올바르지 않은 이름을 넣었을 경우 에러 발생")
  @ValueSource(strings = {"hihisososo", ""})
  void exception(String name) {
    assertThatThrownBy(() -> UserName.of(name)).isInstanceOf(InvalidParameterException.class);
  }
}