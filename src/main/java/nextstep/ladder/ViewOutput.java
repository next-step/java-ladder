package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class ViewOutput {

  public static void render(Players players, Ladder ladder) {
    System.out.println("\n사다리 결과");
    printPlayers(players);
    printLadder(ladder);
  }

  static void printPlayers(Players players) {
    System.out.println(players.getPlayerNames().stream()
        .map(ViewOutput::center)
        .collect(Collectors.joining("", "\n", "")));
  }

  static void printLadder(Ladder ladder) {
    ladder.getHorizons().stream()
        .forEach(horizon -> System.out.printf("%4s%s%n","", horizon));
  }

  static String center(String text) {
    int emptyCount = 9 - text.length();
    int lpad = emptyCount / 2;
    int rpad = emptyCount - lpad;

    return String.format("%s%s%s", padding(lpad), text, padding(rpad));
  }

  private static String padding(int length) {
    return String.format("%" + length + "s", "");
  }
}
