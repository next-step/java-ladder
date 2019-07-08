package ladder.view;

import java.util.Scanner;
import ladder.impl.LadderHeight;
import ladder.impl.Players;
import ladder.impl.Targets;

public class InputView {

  public static final String QUESTION_PLAYERS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  public static final String QUESTION_HEIGHT_LADDER = "최대 사다리 높이는 몇 개인가요?";
  public static final String QUESTION_RESULT_LADDER = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
  public static final String QUESTION_RESULT_OF_PLAYER = "결과를 보고 싶은 사람은?";

  static final Scanner scanner = new Scanner(System.in);

  public static Players askPlayersName() {
    System.out.println(QUESTION_PLAYERS_NAME);
    return Players.of(scanner.next());
  }

  public static Targets askLadderTargets() {
    System.out.println(QUESTION_RESULT_LADDER);
    return Targets.of(scanner.next());
  }

  public static LadderHeight askLadderHeight() {
    System.out.println(QUESTION_HEIGHT_LADDER);
    return LadderHeight.of(scanner.nextInt());
  }

  public static String askResultOfPlayer() {
    System.out.println(QUESTION_RESULT_OF_PLAYER);
    return scanner.next();
  }

}
