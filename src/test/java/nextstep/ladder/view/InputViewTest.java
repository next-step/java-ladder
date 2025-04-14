package nextstep.ladder.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class InputViewTest {

  private static Scanner getTestScanner(String input) {
    return new Scanner(input);
  }

  @Test
  void testReadPlayerName() {
    String testInput = "pobi,crong,jk";
    InputView inputView = new InputView(getTestScanner(testInput));

    String actual = inputView.readPlayers();

    Assertions.assertEquals(testInput, actual);
  }

  @Test
  void testReadLadderHeight() {
    String testInput = "3";
    InputView inputView = new InputView(getTestScanner(testInput));

    int actual = inputView.readLadderHeight();

    Assertions.assertEquals(3, actual);
  }
}