package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static ladder.domain.User.INVALID_USER_NAME_INPUT;
import static ladder.domain.User.MAX_USER_NAME_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

  @ParameterizedTest
  @ValueSource(strings = {"pobi", "honux", "crong", "jk"})
  @DisplayName("유저 이름을 입력하여 " +
      "User를 생성할 수 있으며" +
      "유저 이름이 정상적으로 저장되는지 검증")
  void userTest(String given) {
    User user = new User(given);
    assertThat(user.isSame(given)).isTrue();
  }

  @ParameterizedTest
  @ValueSource(strings = {"pobizzzzz", "pboiii"})
  @DisplayName("유저 이름을 입력하여 " +
      "User를 생성 시" +
      "유저 이름이 최대 길이를 넘는 경우 exception 테스트")
  void userTest2(String given) {
    assertThatThrownBy(() -> new User(given))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(String.format(INVALID_USER_NAME_INPUT, given, MAX_USER_NAME_LENGTH));
  }
}
