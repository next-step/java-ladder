package ladder.view;

import ladder.domain.Ladders;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.Row;

import java.util.stream.IntStream;

public class ResultView {
  private static final String OFFSET = "     ";
  private static final String PARALLEL = "-----";
  private static final String VERTICAL = "|";

  public static void displayResult(Players players, Ladders ladders) {
    printOutInputMessage("실행 결과\n");
    displayPlayers(players);
    displayLadders(ladders);
  }

  private static void displayLadders(Ladders ladders) {
    for (Row row : ladders) {
      displayRow(row);
    }
  }

  private static void displayPlayers(Players players) {
    for (Player player : players) {
      displayPlayer(player);
    }
    newLine();
  }

  private static void displayPlayer(Player player) {
    System.out.printf("%5s", player.name());
  }

  private static void displayRow(Row row) {
    displayOffset();

    for (Boolean isExisting : row) {
      displayVertical();
      displayParallel(isExisting);
    }

    displayVertical();
    newLine();
  }

  private static void displayOffset() {
    System.out.print(OFFSET);
  }

  private static void displayVertical() {
    System.out.print(VERTICAL);
  }

  private static void displayParallel(Boolean exist) {
    if (exist) {
      System.out.print(PARALLEL);
      return;
    }
    System.out.print(OFFSET);
  }

  private static void newLine() {
    System.out.println();
  }

  private static void printOutInputMessage(final String message) {
    System.out.println(message);
  }
}
