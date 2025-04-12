package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LadderGameTest {

  @Test
  void testCreatePlayer() {
    String playerName = "pobi";

    Player player = new Player(playerName);

    assertThat(player).isEqualTo(new Player(playerName));
  }

  @Test
  void testCreatePlayerWithLongerThan5LetterName() {
    String playerName = "pobi123";

    assertThatThrownBy(() -> new Player(playerName))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("이름은 5자 이하여야 합니다.");
  }

  @Test
  void testCreatePlayers() {
    String players = "pobi, crong, jk";

    Players playersList = new Players(players);

    assertThat(playersList.size()).isEqualTo(3);
    assertThat(playersList.toConsoleOutput()).isEqualTo(" pobi crong    jk");
  }

  @Test
  void testCreatePlayersWithLessThan2Players() {
    String players = "pobi";

    assertThatThrownBy(() -> new Players(players))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("참여자는 2명 이상이어야 합니다.");
  }

  @Test
  void testCreateLine() {
    Line line = new Line(new Players("pobi,crong,jk"), () -> true);
    String lineRendered = line.toConsoleOutput();

    String[] segments = lineRendered.trim().split("\\|");
    for (int i = 2; i < segments.length; i++) {
      boolean prevHasLine = segments[i - 1].contains("-----");
      boolean currHasLine = segments[i].contains("-----");
      assertFalse(prevHasLine && currHasLine, "연속된 가로줄 발견: " + segments[i - 1] + " | " + segments[i]);
    }
  }

  @Test
  void testLadderCreatesRightAmountOfHeight() {
    int height = 3;
    Players players = new Players("pobi,crong,jk");

    Ladder ladder = new Ladder(height, players, () -> false);

    String[] lines = ladder.toConsoleOutput().split("\n");
    assertEquals(height, lines.length);
  }

  @Test
  void testLadderCreatesPlayersCounts() {
    int height = 1;
    Players players = new Players("pobi,crong,jk");

    Ladder ladder = new Ladder(height, players, () -> true);

    String rendered = ladder.toConsoleOutput();
    long count = rendered.chars().filter(c -> c == '|').count();
    assertEquals(players.size()*height, count);
  }

  @Test
  void testPrintResult() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    Players players = new Players("pobi,crong,jk");
    Ladder ladder = new Ladder(3, players, () -> true);
    String expected = "실행 결과\n" +
        "\n" +
        " pobi crong    jk\n" +
        "     |----|    |\n" +
        "     |----|    |\n" +
        "     |----|    |\n";

    OutputView.printResult(players, ladder);

    System.setOut(originalOut);
    assertEquals(expected, outputStream.toString());
  }

  private static Scanner getTestScanner(String input) {
    return new Scanner(input);
  }

  @Test
  void testReadPlayerName() {
    String testInput = "pobi,crong,jk";
    InputView inputView = new InputView(getTestScanner(testInput));

    String actual = inputView.readPlayers();

    assertEquals(testInput, actual);
  }

  @Test
  void testReadLadderHeight() {
    String testInput = "3";
    InputView inputView = new InputView(getTestScanner(testInput));

    int actual = inputView.readLadderHeight();

    assertEquals(3, actual);
  }
}
