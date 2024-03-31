package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.LadderHeight;
import ladder.domain.LadderLine;

import java.util.List;
import java.util.Map;

public class ResultView {

  public void printResult(LadderGame ladderGame) {
    System.out.println("\n실행 결과\n");
    printNames(ladderGame.getUserNames());
    printLadders(ladderGame.getLineInfoMap());
  }

  private static void printNames(List<String> names) {
    names.forEach(name -> System.out.print(name + " "));
    System.out.println();
  }

  private void printLadders(Map<LadderHeight, LadderLine> map) {
    map.values().forEach(lines -> {
      System.out.print("|");
      printLine(lines);
      System.out.println();
    });
  }

  private void printLine(LadderLine lines) {
    for (int i = 0; i < lines.size(); i++) {
      System.out.print(lines.printLine(i));
      System.out.print("|");
    }
  }
}