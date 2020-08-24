package nextstep.ladder;

import java.util.Scanner;

public class ViewInput {

  public static final String SCRIPT_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  public static final String SCRIPT_LADDER_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?";

  private Scanner scanner;

  public ViewInput(Scanner scanner) {
    this.scanner = scanner;
  }

  public Players ready() {
    String playerNames = playerNames();
    int ladderHeight = ladderHeight();

    return Players.valueOf(playerNames, ladderHeight);
  }

  private String playerNames() {
    System.out.println(SCRIPT_PLAYER_NAMES);
    return scanner.next();
  }

  private int ladderHeight() {
    System.out.println(SCRIPT_LADDER_HEIGHT);
    return scanner.nextInt();
  }

}
