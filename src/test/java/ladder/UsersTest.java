package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


class UsersTest {

  private Users users;

  @BeforeEach
  public void setUp() {
    users = new Users("pobi,oneny,twony");
  }

  @Test
  @DisplayName(",를 구분자로 여러 유저 생성")
  public void create_유저들() {
    assertAll(
            () -> assertThat(users.findUserByIndex(0).name()).isEqualTo("pobi"),
            () -> assertThat(users.findUserByIndex(1).name()).isEqualTo("oneny"),
            () -> assertThat(users.findUserByIndex(2).name()).isEqualTo("twony")
    );
  }

  @Test
  @DisplayName("유저수 반환 테스트")
  public void check_유저수() {
    assertThat(users.countOfUser()).isEqualTo(3);
  }
}
