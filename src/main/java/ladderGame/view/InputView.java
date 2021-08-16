package ladderGame.view;

import java.util.Scanner;

public class InputView {

  private static Scanner scanner = new Scanner(System.in);

  public static String inputUserNamesWithMessage(final String message) {
    System.out.println(message);
    return scanner.nextLine();
  }

  public static int inputLadderHeightWithMessage(final String message) {
    System.out.println(message);
    return scanner.nextInt();
  }
}