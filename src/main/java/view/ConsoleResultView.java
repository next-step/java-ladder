package view;

import domain.Ladder;
import domain.Line;
import domain.Participant;
import domain.Point;
import domain.Result;
import java.util.Map;
import java.util.stream.IntStream;

public class ConsoleResultView {

  public static void printCreatedLadder(Ladder ladder) {

    System.out.println("실행결과\n");
    System.out.println(ladder.getParticipants().names());

    ladder.getLines().gets()
        .forEach(ConsoleResultView::printLine);
    System.out.println(ladder.getResults());
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

  public static void printResult(Result result) {
    System.out.println(result);
  }

  public static void printLadderResults(Map<Participant, Result> ladderResults) {
    ladderResults.keySet()
        .forEach(participant -> System.out.println(participant + ":" + ladderResults.get(participant)));
  }
}
