package ladderGame.step4.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class PrizesTest {

  @DisplayName("상품들 생성 테스트.")
  @Test
  void create() {
    String prizes = "꽝,5000,10000,꽝";
    Prizes prizes1 = new Prizes(Prizes.createPrizes(prizes, 4));
    Prizes prizes2 = new Prizes(Prizes.createPrizes(prizes, 4));

    assertThat(prizes1).isEqualTo(prizes2);
  }

  @DisplayName("상품등록수와 참여자가수간의 일치여부 확인.")
  @ParameterizedTest
  @NullSource
  @EmptySource
  @ValueSource(strings = "꽝,1000")
  void invalidPrizes(String prizes) {
    assertThatThrownBy(() -> new Prizes(Prizes.createPrizes(prizes, 3)))
        .isInstanceOf(IllegalArgumentException.class);
  }
}