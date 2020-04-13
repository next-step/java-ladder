package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Players;

public class InputView {

  private static final String DELIMITER = ",";
  private static final String PLAYER_NAMES_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  private static final String PRIZE_QUESTION = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
  private static final String LADDER_HEIGHT_QUESTION = "최대 사다리 높이는 몇 개인가요?";

  private Scanner scanner;

  public InputView() {
    scanner = new Scanner(System.in);
  }

  public Players acceptPlayers() {
    printWithNewLine(PLAYER_NAMES_QUESTION);
    String nameInput = scanner.nextLine();
    List<String> names = Arrays.stream(nameInput.split(DELIMITER))
        .collect(Collectors.toList());

    return Players.withNames(names);
  }

  public List<String> writePrizes() {
    printWithNewLine(PRIZE_QUESTION);
    String prizeInput = scanner.nextLine();
    List<String> prizes = Arrays.stream(prizeInput.split(DELIMITER))
        .collect(Collectors.toList());

    return prizes;
  }

  public int askLadderHeight() {
    printWithNewLine(LADDER_HEIGHT_QUESTION);
    return Integer.parseInt(scanner.nextLine());
  }

  private void printWithNewLine(String sentence) {
    System.out.println();
    System.out.println(sentence);
  }
}
