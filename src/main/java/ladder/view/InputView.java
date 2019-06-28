package ladder.view;

import java.util.Scanner;

public class InputView {

  public static final String QUESTION_PLAYERS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  public static final String QUESTION_HEIGHT_LADDER = "최대 사다리 높이는 몇 개인가요?";

  static final Scanner scanner = new Scanner(System.in);

  public String askPlayersName() {
    System.out.println(QUESTION_PLAYERS_NAME);
    return scanner.next();
  }



}
