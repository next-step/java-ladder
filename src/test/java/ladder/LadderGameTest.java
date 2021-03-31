package ladder;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import ladder.domain.LadderGame;
import ladder.domain.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderGameTest {

  private String[] names;

  @BeforeEach
  void setUp() {
    names = new String[]{"pobi", "honux", "crong", "jk"};
  }

  @Test
  @DisplayName("LadderGame 객체 테스트")
  public void create() {
    LadderGame ladderGame = new LadderGame(5, names);
    Users users = new Users(names);
    assertThat(ladderGame.getUsers()).isEqualTo(users);
    assertThat(ladderGame.getLines().size()).isEqualTo(5);
  }

  @ParameterizedTest
  @ValueSource(ints = {0,-1,-3})
  @DisplayName("높이가 음수이거나 0인 경우 확인")
  public void validateHeight(int number) {
    assertThatThrownBy(() -> {
      LadderGame ladderGame = new LadderGame(number, names);
    }).isInstanceOf(IllegalArgumentException.class);

  }


}
