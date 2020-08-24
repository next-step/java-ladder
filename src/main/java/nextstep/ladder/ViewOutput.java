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
        .collect(Collectors.joining(" ")));
  }

  static void printLadder(List<Horizon> ladder) {
    for (Horizon horizon : ladder) {
      System.out.println(horizon.asString());
    }
  }
}
