package view;

import domain.Ladder;
import domain.Line;
import domain.Participant;
import domain.Point;
import java.util.stream.IntStream;

public class ConsoleResultView {

  public static void printCreatedLadder(Ladder ladder) {

    System.out.println("실행결과\n");
    System.out.println(ladder.getParticipants().names());

    ladder.getLines().gets()
        .forEach(ConsoleResultView::printLine);
  }

  private static void printLine(Line line) {
    line.getPoints().forEach(ConsoleResultView::printPoint);
    System.out.print("\n");
  }

  private static void printPoint(Point point) {
    IntStream.range(0, Participant.MAXIMUM_NAME_LENGTH)
        .forEach(index -> System.out.print(point.is() ? "-" : " "));
    System.out.print("|");
  }
}
