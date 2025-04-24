package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class OutputViewTest {

  @Test
  void testPrintLadder() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    Players players = new Players("pobi,crong,jk");
    Ladder ladder = new Ladder(3, players, () -> true, "1, 2, 3");
    String expected = "실행 결과\n" +
            "\n" +
            " pobi crong    jk\n" +
            "     |-----|     |\n" +
            "     |-----|     |\n" +
            "     |-----|     |\n";

    OutputView.printLadder(players, ladder);

    System.setOut(originalOut);
    Assertions.assertEquals(expected, outputStream.toString());
  }

  @Test
  void testPrintAllResult() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    Map<Player, String> results = new LinkedHashMap<>();
    results.put(new Player("pobi"), "1");
    results.put(new Player("crong"), "2");
    results.put(new Player("jk"), "3");

    OutputView.printAllResult(results);

    System.setOut(originalOut);
    Assertions.assertEquals(
            "실행 결과\n" +
                    " pobi : 1\n" +
                    "crong : 2\n" +
                    "   jk : 3\n", outputStream.toString());
  }

  @Test
  void testPrintResult() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    String result = "1";
    OutputView.printResult(result);

    System.setOut(originalOut);
    Assertions.assertEquals("실행 결과\n" + result + "\n", outputStream.toString());
  }
}