package ladder;

import static ladder.LineIndexTest.FIRST_LINE_INDEX;
import static ladder.PlayersTest.PLAYERS_1;
import static ladder.PrizeTest.PRIZE_LIST_1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class PrizesTest {


  public static final Prizes PRIZES_1 = new Prizes(PRIZE_LIST_1, PLAYERS_1.playerNumber());

  @Test
  void Prizes_생성_성공() {
    assertDoesNotThrow(() -> new Prizes(List.of(new Prize("1")), 1));
  }

  @Test
  void Prizes_생성_실패() {
    assertThrows(IllegalArgumentException.class, () -> new Prizes(List.of(new Prize("1")), 2));
  }

  @Test
  void prizes_성공() {
    assertThat(PRIZES_1.prizes()).isEqualTo(PRIZE_LIST_1.stream()
        .map(Prize::toString)
        .collect(Collectors.toUnmodifiableList()));
  }

  @Test
  void prizeFrom_성공() {
    Prize expected = PRIZE_LIST_1.get(0);
    assertThat(PRIZES_1.prizeFrom(FIRST_LINE_INDEX)).isEqualTo(expected);
  }

  @Test
  void of_성공() {
    String text = "1,2,3,4,5";
    assertThat(Prizes.of(text, PLAYERS_1)).isEqualTo(PRIZES_1);
  }
}
