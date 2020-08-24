package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class ViewOutput {

  public static void render(Players players, List<Horizon> ladder) {
    printPlayers(players);
    printLadder(ladder);
  }

  static void printPlayers(Players players) {
    System.out.println(players.getPlayerNames().stream()
        .map(name -> center(name))
        .collect(Collectors.joining("", "\n", "")));
  }

  static void printLadder(List<Horizon> ladder) {
    for (Horizon horizon : ladder) {
      System.out.println(String.format("%4s%s","", horizon.asString()));
    }
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
