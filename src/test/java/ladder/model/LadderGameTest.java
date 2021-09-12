package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {

  @Test
  @DisplayName("생성테스트")
  void createTest() {
    //given
    String names = "  pobi,  honux , crong ,  jk  ";
    int height = 5;

    //when
    LadderGame ladderGame = new LadderGame(names, height);

    //then
    Ladder ladder = ladderGame.ladder();
    assertThat(ladder.width()).isEqualTo(4);
    assertThat(ladder.height()).isEqualTo(height);

    assertThat(ladderGame.participants()).containsExactly("pobi", "honux", "crong", "jk");
  }

  @Test
  @DisplayName("잘못된 생성 테스트")
  void invalidCreateTest() {
    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LadderGame("", 5);
    });

    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LadderGame(" ,  ,  ", 5);
    });

    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LadderGame("pobi", 5);
    });

    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LadderGame("pobi,honux,crong,jk", 0);
    });

    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LadderGame("", 0);
    });
  }
}
