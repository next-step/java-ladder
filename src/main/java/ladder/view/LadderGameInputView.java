package ladder.view;

import java.util.NoSuchElementException;
import java.util.Scanner;
import ladder.exception.UserInputFailException;

public class LadderGameInputView {

  private static final String USER_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  private static final String HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
  private final Scanner scanner;
  private String ladderUserNames;
  private int ladderHeight;

  public LadderGameInputView() {
    this.scanner = new Scanner(System.in);
  }

  public void inputLadderUsers() {
    System.out.println(USER_INPUT_MESSAGE);
    ladderUserNames = nextLine();
  }

  public void inputLadderHeight() {
    System.out.println(HEIGHT_INPUT_MESSAGE);
    ladderHeight = nextInt();
  }

  private int nextInt() {
    try {
      return scanner.nextInt();
    } catch (NoSuchElementException | IllegalStateException e) {
      throw new UserInputFailException();
    }
  }

  private String nextLine() {
    try {
      return scanner.nextLine();
    } catch (NoSuchElementException | IllegalStateException e) {
      throw new UserInputFailException();
    }
  }

  public String getLadderUserNames() {
    return ladderUserNames;
  }

  public int getLadderHeight() {
    return ladderHeight;
  }
}
