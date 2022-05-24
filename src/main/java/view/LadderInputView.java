package view;

import java.util.Scanner;
import ladder.Height;
import ladder.Name;
import ladder.Players;
import ladder.Prizes;

public class LadderInputView {

  private static final String INPUT_PLAYERS_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  private static final String INPUT_RESULTS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
  private static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
  private static final String INPUT_NAME = "결과를 보고 싶은 사람은?";

  private final Scanner scanner = new Scanner(System.in);

  public Players inputPlayers() {
    return Players.of(scanString(INPUT_PLAYERS_MESSAGE));
  }

  public Height inputHeight() {
    return new Height(scanInt(INPUT_LADDER_HEIGHT));
  }

  public Prizes inputResults(Players players) {
    return Prizes.of(scanString(INPUT_RESULTS_MESSAGE), players);
  }

  public Name inputName() {
    return Name.of(scanString(INPUT_NAME));
  }

  private Integer scanInt(String description) {
    printDescription(description);
    return Integer.parseInt(scanner.nextLine());
  }

  private String scanString(String description) {
    printDescription(description);
    return scanner.nextLine();
  }

  private void printDescription(String description) {
    System.out.println(description);
  }
}
