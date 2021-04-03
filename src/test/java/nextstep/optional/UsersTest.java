package nextstep.optional;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UsersTest {

  @Test
  void getUser() {
    Users users = new Users();
    assertThat(users.getUser("crong")).isEqualTo(new User("crong", 35));
  }

  @Test
  void getDefaultUser() {
    Users users = new Users();
    assertThat(users.getUser("codesquard")).isEqualTo(Users.DEFAULT_USER);
  }
}
