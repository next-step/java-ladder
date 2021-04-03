package ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import ladder.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
  @Test
  @DisplayName("유저 이름 확인")
  public void create() {
    User user = new User("dayeon",0);
    assertThat(user.name()).isEqualTo("dayeon");
  }
}
