package step2;

import step2.controller.LadderGame;
import step2.view.InputView;

import java.util.Scanner;

public class App {
  public static void main(String... args) {
    new LadderGame(
      new InputView(new Scanner(System.in))
    ).run();
  }
}
