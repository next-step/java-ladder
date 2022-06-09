package ladder;

import static java.util.Collections.emptyList;
import static ladder.LineTest.LINE_1;
import static ladder.LineTest.LINE_2;
import static ladder.PlayerTest.PLAYER_NAME_LIST_1;
import static ladder.PlayersTest.PLAYERS_1;
import static ladder.PrizeTest.PRIZE_LIST_1;
import static ladder.PrizesTest.PRIZES_1;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

  public static final Ladder LADDER = new Ladder(List.of(LINE_1, LINE_2));

  @Test
  void Ladder_생성_성공() {
    assertDoesNotThrow(() -> new Ladder(List.of(LINE_1, LINE_2)));
  }

  @Test
  void Ladder_생성_실패() {
    assertThrows(IllegalArgumentException.class, () -> new Ladder(emptyList()));
  }

  @Test
  void lines_성공() {
    assertThat(LADDER.lines()).isEqualTo(List.of(LINE_1, LINE_2));
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3, 4})
  void findResult_성공(int index) {
    assertThat(LADDER.findResult(
        PRIZES_1, LineIndex.init(PLAYERS_1, PLAYER_NAME_LIST_1.get(index))
    )).isEqualTo(PRIZE_LIST_1.get(index));
  }

  @Test
  void from_성공() {
    Height height = new Height(4);

    Ladder ladder = Ladder.from(PLAYERS_1, height);

    List<Line> lines = ladder.lines();
    assertThat(lines.size()).isEqualTo(4);
    assertThat(lines.get(0).points().size()).isEqualTo(PLAYERS_1.sizeOfPlayers());
  }
}
