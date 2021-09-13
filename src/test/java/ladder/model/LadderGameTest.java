package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    assertThat(ladderGame.ladderWidth()).isEqualTo(4);
    assertThat(ladderGame.ladderHeight()).isEqualTo(height);

    assertThat(ladderGame.participants()).containsExactly("pobi", "honux", "crong", "jk");
  }

  @ParameterizedTest(name = "잘못된 생성 테스트 names:[{0}], height:[{1}]")
  @CsvSource(
      value = {"''|5", " ,  , |5", "pobi|5", "pobi,honux,crong,jk|0", "''|0"},
      delimiter = '|'
  )
  void invalidCreateTest(String names, int height) {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LadderGame(names, height);
    });
  }
}
