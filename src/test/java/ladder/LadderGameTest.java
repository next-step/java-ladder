package ladder;


import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import ladder.domain.LadderGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderGameTest {

  private String[] names;
  private String[] prizes;

  @BeforeEach
  void setUp() {
    names = new String[]{"pobi", "honux", "crong"};
    prizes = new String[]{"꽝", "3000", "2000"};

  }

  @ParameterizedTest
  @ValueSource(ints = {0, -1, -3})
  @DisplayName("높이가 음수이거나 0인 경우 확인")
  public void validateHeight(int number) {
    assertThatThrownBy(() -> {
      LadderGame ladderGame = new LadderGame(number, names, prizes);
    }).isInstanceOf(IllegalArgumentException.class);

  }


}
