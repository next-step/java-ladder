package view;

import java.util.List;
import java.util.StringJoiner;
import ladder.Ladder;
import ladder.Line;
import ladder.Players;

public class LadderOutputView {

  private static final String RESULT = "실행결과";
  private static final String LINE = "|";
  private static final String POINT = "-----";
  private static final String NOT_POINT = "     ";
  private static final String NEW_LINE = "\n";
  private static final String BLANK = " ";
  private static final int NAME_DISTANCE = 6;

  public void printResult() {
    print(RESULT);
  }

  public void printLine(Ladder ladder) {
    List<Line> lines = ladder.lines();
    StringJoiner stringJoiner = new StringJoiner(NEW_LINE);
    for (Line line : lines) {
      stringJoiner.add(lineToString(line));
    }
    print(stringJoiner.toString());
  }

  public void printPlayerNames(Players players) {
    List<String> names = players.playerNames();
    StringBuilder stringBuilder = new StringBuilder();
    for (String name : names) {
      stringBuilder.append(name)
          .append(BLANK.repeat(NAME_DISTANCE - name.length()));
    }
    print(stringBuilder.toString());
  }

  private String lineToString(Line line) {
    List<Boolean> points = line.points();
    StringBuilder lineStringBuilder = new StringBuilder();
    for (int i = 0; i + 1 < points.size(); i++) {
      lineStringBuilder.append(LINE);
      lineStringBuilder.append(pointToString(points.get(i)));
    }
    lineStringBuilder.append(LINE);
    return lineStringBuilder.toString();
  }

  private String pointToString(Boolean point) {
    if (point) {
      return POINT;
    }
    return NOT_POINT;
  }

  private void print(String text) {
    System.out.println(text);
  }
}
