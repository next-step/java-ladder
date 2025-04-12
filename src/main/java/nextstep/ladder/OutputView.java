package nextstep.ladder;

public class OutputView {
  public static void printResult(Players players, Ladder ladder) {
    System.out.println("실행 결과\n");
    System.out.println(players.toConsoleOutput());
    System.out.println(ladder.toConsoleOutput());
  }
}
