package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.security.InvalidParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserNamesTest {

  @ParameterizedTest
  @DisplayName("사용자 이름들이 잘 생성되는지 확인")
  @ValueSource(strings = {"pobi,honux,crong,jk", "java,lyj", "user1,user2,user3,user4"})
  void of(String names) {
    assertThat(GameUsers.from(names)).usingRecursiveComparison().isEqualTo(GameUsers.from(names));
  }

  @ParameterizedTest
  @DisplayName("올바르지 않은 사용자 이름들 입력일 경우 에러")
  @ValueSource(strings = {"hihisososo,user", ""})
  void exception() {
    assertThatThrownBy(() -> GameUsers.from("")).isInstanceOf(InvalidParameterException.class);
  }
}