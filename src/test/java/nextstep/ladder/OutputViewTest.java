package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.OutputView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OutputViewTest {

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
    Assertions.assertEquals(expected, outputStream.toString());
  }
}