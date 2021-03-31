package ladder;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import ladder.domain.LadderGame;
import ladder.domain.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

  @Test
  @DisplayName("LadderGame 객체 테스트")
  public void create() {
    List<String> names = Arrays.asList(new String[]{"pobi", "honux", "crong", "jk"});
    LadderGame ladderGame = new LadderGame(5, names);

    Users users = new Users(names);

    assertThat(ladderGame.getUsers()).isEqualTo(users);
  }

}
