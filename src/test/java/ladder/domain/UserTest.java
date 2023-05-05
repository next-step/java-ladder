package ladder.domain;

import ladder.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
  @Test
  @DisplayName("5글자 이하 유저이름 반환 테스트")
  public void create_유저이름() {
    assertThat(new User("oneny").name()).isEqualTo("oneny");
  }

  @Test
  @DisplayName("유저이름 5글자 초과하는 경우 IllegalArgumentException throw 테스트")
  public void create_5글자_초과_유저이름() {
    assertThatThrownBy(() -> new User("threeny"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이름은 최대 5글자까지 부여할 수 있습니다. 현재 이름 : threeny");
  }
}
