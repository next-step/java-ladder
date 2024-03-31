package ladder.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

  private static List<User> USERS;
  @BeforeAll
  static void beforeAll() {
    USERS = List.of(
        new User("pobi"),
        new User("honux"),
        new User("crong"),
        new User("jk")
    );
  }

  @Test
  @DisplayName("사다리 라인 size를 입력하여 " +
      "LadderGame을 생성할 수 있으며" +
      "사다리 길이가 정상적으로 생성되는지 검증")
  void ladderGameTest() {
    int height = 5;
    LadderGame ladderGame = LadderGame.start(USERS, new LadderHeight(height));
    assertThat(ladderGame.isSameLadderHeight(height)).isTrue();
  }
}
