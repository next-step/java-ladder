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

  @Test
  void testReadLadderHeightWithInvalidInput() {
    String testInput = "abc";
    InputView inputView = new InputView(getTestScanner(testInput));

    Assertions.assertThrows(IllegalArgumentException.class, inputView::readLadderHeight);
  }

  @Test
  void testReadResult() {
    String testInput = "1,2,3";
    InputView inputView = new InputView(getTestScanner(testInput));

    String actual = inputView.readResult();

    Assertions.assertEquals(testInput, actual);
  }

  @Test
  void testReadResultQuery() {
    String testInput = "pobi";
    InputView inputView = new InputView(getTestScanner(testInput));

    String actual = inputView.readResultQuery();

    Assertions.assertEquals(testInput, actual);
  }
}