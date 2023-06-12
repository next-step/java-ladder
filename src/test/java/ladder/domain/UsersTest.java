package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UsersTest {

  private Users users;

  @BeforeEach
  public void beforeEach() {
    User kilby = new User("kilby");
    User david = new User("Kahng");
    User feynman = new User("fyman");
    users = new Users(List.of(kilby, david, feynman));
  }


  @DisplayName("관리하는 user 수를 리턴한다")
  @Test
  public void count() {
    int count = users.count();
    assertThat(count).as("").isEqualTo(3);
  }

  @DisplayName("모든 유저의 이름을 가져온다")
  @Test
  public void names() {
    List<String> names = users.names();
    assertThat(names).as("").contains("kilby");
    assertThat(names).as("").contains("Kahng");
    assertThat(names).as("").contains("fyman");
  }
}
