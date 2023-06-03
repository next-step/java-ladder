package nextstep.laddergame.factory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.laddergame.domain.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizesFactoryTest {

  @DisplayName("입력받은 result수 만큼 Prize를 생성한다.")
  @Test
  public void createPrizes() {
    String[] results = {"꽝", "100", "1000"};
    Prizes prizes = PrizesFactory.createPrizes(results, results.length);

    assertThat(prizes.getPrizes().size()).isEqualTo(results.length);
  }

  @DisplayName("생성하는 Prize개수와 Ladder의 넓이가 같지 않으면 예외를 던진다.")
  @Test
  public void createPrizes_throwException_ifNotEqualWidth() {
    String[] results = {"꽝", "100", "1000"};

    assertThatThrownBy(() -> PrizesFactory.createPrizes(results, 2))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
