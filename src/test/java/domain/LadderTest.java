package domain;

import common.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static common.Constants.MIN_LADDER_HEIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

  @Test
  @DisplayName("Ladder 객체가 잘 생성되는지 검증하는 테스트")
  void makeLadder(){
    // given
    int ladderHeight = 5;
    int playerAmount = 4;

    // when
    Ladder ladder = new Ladder(ladderHeight, playerAmount);

    // then
    assertThat(ladder).isNotNull();
    assertThat(ladder.getFloors().size()).isEqualTo(ladderHeight);
  }

  @Test
  @DisplayName("MIN_LADDER_HEIGHT 보다 작은 수의 height를 갖는 사다리는 생성할 수 없음을 검증하는 테스트")
  void ladderHeightCannotLowerThan_MIN_LADDER_HEIGHT(){
    // given
    int wrongHeight = MIN_LADDER_HEIGHT - 1;
    int numberOfPlayers = 4;

    assertThatThrownBy(() ->
            // when
            new Ladder(wrongHeight, numberOfPlayers)
    // then
    ).isInstanceOf(IllegalArgumentException.class)
            .withFailMessage(ErrorMessages.LADDER_HEIGHT_IS_TOO_SHORT);
  }

}
