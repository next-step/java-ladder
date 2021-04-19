package ladder.model.prize;

import ladder.error.NotMatchedSizesException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizesTest {
  @Test
  @DisplayName("이름 개수와 결과 개수가 같지 않을 때 예외 처리 테스트")
  void invalidMakeTest() {
    String prizes = "꽝,떡볶이";
    int numberOfPlayers = 3;

    Assertions.assertThatThrownBy(() ->
      Prizes.makePrizes(prizes, numberOfPlayers)
    ).isInstanceOf(NotMatchedSizesException.class)
      .hasMessage("참가자와 결과의 수가 일치하지 않습니다.");
  }

}
