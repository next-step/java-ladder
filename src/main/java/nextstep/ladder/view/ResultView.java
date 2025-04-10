package nextstep.ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.Ladder;
import nextstep.ladder.Line;
import nextstep.ladder.Participants;
import nextstep.ladder.Results;

public class ResultView {

  public static void printTitle() {
    System.out.println("\n실행결과");
  }

  public static void printParticipants(Participants participants) {
    participants.names().forEach(name -> System.out.printf("%" + (Participants.MAX_NAME_LENGTH + 1) + "s", name));
    System.out.println();
  }

  public static void printLadder(Ladder ladder) {
    for (Line line : ladder.lines()) {
      printLine(line);
    }
  }

  private static void printLine(Line line) {
    System.out.println(" ".repeat(Participants.MAX_NAME_LENGTH) + buildLine(line));
  }

  private static String buildLine(Line line) {
    List<Boolean> points = line.points();

    return IntStream.range(0, points.size() + 1)
        .mapToObj(i -> {
          String bar = "|";
          if (i < points.size()) {
            bar += segment(points.get(i));
          }
          return bar;
        })
        .collect(Collectors.joining());
  }

  private static String segment(boolean connected) {
    String unit = connected ? "-" : " ";
    return unit.repeat(Participants.MAX_NAME_LENGTH);
  }

  public static void printResults(Results results) {
    String output = results.values().stream()
        .map(result -> String.format("%" + (Participants.MAX_NAME_LENGTH + 1) + "s", result))
        .collect(Collectors.joining());
    System.out.println(output);
  }

  public static void printSingleResult(String result) {
    System.out.println("\n실행 결과");
    System.out.println(result);
  }

  public static void printAllResults(java.util.Map<String, String> resultMap) {
    System.out.println("\n실행 결과");
    resultMap.entrySet().stream()
        .map(entry -> entry.getKey() + " : " + entry.getValue())
        .forEach(System.out::println);
  }
}
