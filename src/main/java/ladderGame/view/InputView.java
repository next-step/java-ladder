package ladderGame.view;

import java.util.Scanner;

public class InputView {

  public static String inputUserNamesWithMessage(final String message) {
    System.out.println(message);

    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  public static int inputLadderHeightWithMessage(final String message) {
    System.out.println(message);

    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }
}