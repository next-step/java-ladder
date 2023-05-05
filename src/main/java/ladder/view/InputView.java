package ladder.view;

import ladder.domain.LadderHeight;

import java.util.Scanner;

import static ladder.utils.LadderUtil.HEIGHT_INPUT_MESSAGE;
import static ladder.utils.LadderUtil.USERS_INPUT_MESSAGE;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);

  public static String inputUsers() {
    System.out.println(USERS_INPUT_MESSAGE);

    return SCANNER.nextLine();
  }

  public static LadderHeight inputHeight() {
    System.out.println(HEIGHT_INPUT_MESSAGE);

    return new LadderHeight(SCANNER.nextInt());
  }
}
