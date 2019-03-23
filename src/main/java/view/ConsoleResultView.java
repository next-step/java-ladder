package view;

import domain.Ladder;
import domain.Line;

public class ConsoleResultView {

  public static void printCreatedLadder(Ladder ladder) {

    System.out.println("실행결과\n");
    System.out.println(ladder.getParticipantNames());

    ladder.getLines()
        .forEach(ConsoleResultView::printLine);
  }

  private static void printLine(Line line) {
    line.getPoints().forEach(ConsoleResultView::printPoint);
    System.out.print("\n");
  }

  private static void printPoint(Boolean point) {
    System.out.print(point ? "-----" : "     ");
    System.out.print("|");
  }
}
