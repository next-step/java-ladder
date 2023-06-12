package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ladder.exception.OutOfUserNameLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

  @DisplayName("userName 의 길이가 5를 초과하는 경우 예외를 던진다")
  @Test
  public void userNameLength() {
    assertThatThrownBy(() -> {
      new User("여섯글자이름");
    }).isInstanceOf(OutOfUserNameLengthException.class)
        .hasMessageContaining("유저 이름의 길이 제한을 초과하였습니다");
  }
}
