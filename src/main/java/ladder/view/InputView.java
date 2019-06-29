package ladder.view;

import java.util.Scanner;
import ladder.LadderGameInformation;
import ladder.Players;

public class InputView {

  public static final String QUESTION_PLAYERS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  public static final String QUESTION_HEIGHT_LADDER = "최대 사다리 높이는 몇 개인가요?";

  static final Scanner scanner = new Scanner(System.in);

  public static LadderGameInformation askLadderGameInformation() {
    Players players = askPlayersName();
    int height = askLadderHeight();
    return new LadderGameInformation(players,height);
  }

  private static Players askPlayersName() {
    System.out.println(QUESTION_PLAYERS_NAME);
    String playersName =  scanner.next();
    return new Players(playersName);
  }

  private static int askLadderHeight() {
    System.out.println(QUESTION_HEIGHT_LADDER);
    return scanner.nextInt();
  }



}
