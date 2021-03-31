package ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import ladder.domain.LadderGame;
import ladder.domain.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UsersTest {

  @Test
  @DisplayName("중복 이름 확인")
  public void validateDuplicatedName() {
    assertThatThrownBy(() -> {
      String[] names = new String[]{"pobi", "pobi"};
      Users users = new Users(names);
    }).isInstanceOf(IllegalArgumentException.class);
  }

}
