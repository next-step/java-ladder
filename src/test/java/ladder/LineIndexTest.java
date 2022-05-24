package ladder;

import static ladder.NameTest.PLAYER_NAME_LIST_1;
import static ladder.PlayersTest.PLAYERS_1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LineIndexTest {

  public static final LineIndex FIRST_LINE_INDEX = LineIndex.init(
      PLAYERS_1, PLAYER_NAME_LIST_1.get(0)
  );
  public static final LineIndex SECOND_LINE_INDEX = LineIndex.init(
      PLAYERS_1, PLAYER_NAME_LIST_1.get(1)
  );
  public static final LineIndex THIRD_LINE_INDEX = LineIndex.init(
      PLAYERS_1, PLAYER_NAME_LIST_1.get(2)
  );

  @Test
  void LineIndex_생성_성공() {
    assertDoesNotThrow(() -> new LineIndex(5, 0));
    assertDoesNotThrow(() -> new LineIndex(5, 4));
  }

  @Test
  void LinIndex_생성_실패() {
    assertThrows(IllegalArgumentException.class, () -> new LineIndex(5, 5));
    assertThrows(IllegalArgumentException.class, () -> new LineIndex(5, -1));
  }

  @Test
  void moveRight() {
    LineIndex lineIndex = new LineIndex(3, 0);
    LineIndex expected = new LineIndex(3, 1);

    assertThat(lineIndex.moveRight()).isEqualTo(expected);
  }

  @Test
  void moveLeft_성공() {
    LineIndex lineIndex = new LineIndex(3, 1);
    LineIndex expected = new LineIndex(3, 0);

    assertThat(lineIndex.moveLeft()).isEqualTo(expected);
  }

  @Test
  void value_성공() {
    Name firstPlayer = PLAYER_NAME_LIST_1.get(0);

    LineIndex lineIndex = LineIndex.init(PLAYERS_1, firstPlayer);

    assertThat(lineIndex.value()).isEqualTo(0);
  }

  @Test
  void equals_성공() {
    assertThat(new LineIndex(3, 1)).isEqualTo(new LineIndex(3, 1));
  }

  @Test
  void init_성공() {
    Name firstPlayer = PLAYER_NAME_LIST_1.get(0);
    LineIndex expected = new LineIndex(PLAYER_NAME_LIST_1.size(), 0);

    LineIndex lineIndex = LineIndex.init(PLAYERS_1, firstPlayer);

    assertThat(lineIndex).isEqualTo(expected);
  }
}
