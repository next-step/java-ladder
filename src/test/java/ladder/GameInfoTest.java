package ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import ladder.domain.GameInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameInfoTest {

  @Test
  @DisplayName("유저 수와 결과 수 일치하는 지 확인")
  public void validateUserAndPrize() {
    assertThatThrownBy(() -> {
      String[] names = new String[]{"pobi", "honux", "crong","abab"};
      String[] prizes = new String[]{"꽝","3000","2000"};

      GameInfo gameInfo = new GameInfo(names,prizes);
    }).isInstanceOf(IllegalArgumentException.class);

  }

}
