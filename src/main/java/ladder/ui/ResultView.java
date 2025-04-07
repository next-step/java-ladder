package ladder.ui;

import java.util.List;
import ladder.domain.Ladder;
import ladder.domain.Line;

public class ResultView {
  private static final String NAME_FORMAT = "%5s"; // 5글자 이름
  private static final String VERTICAL = "|";
  private static final String HORIZONTAL = "-----";

  private ResultView() {}

  public static void printLadder(Ladder ladder) {
    System.out.println("\n실행결과\n");
    printPlayers(ladder);
    printLines(ladder);
  }

  private static void printPlayers(Ladder ladder) {
    StringBuilder sb = new StringBuilder();

    for (String name : ladder.getPlayers().getNames()) {
      sb.append(String.format(NAME_FORMAT, name)).append(" ");
    }

    System.out.println(sb.toString());
  }

  private static void printLines(Ladder ladder) {
    List<Line> lines = ladder.getLines();
    for (Line line : lines) {
      System.out.println(makeLadderLine(line, ladder.getPlayers().size()));
    }
  }

  private static String makeLadderLine(Line line, int countOfPerson) {
    StringBuilder sb = new StringBuilder();

    // 먼저 세로 라인을 그림
    for (int i = 0; i < countOfPerson; i++) {
      sb.append("    ").append(VERTICAL).append(" ");
    }

    // 가로 라인 추가
    for (int i = 0; i < line.getPointsSize(); i++) {
      if (line.hasPoint(i)) {
        int position = i * 6 + 5; // 세로 라인 바로 다음 위치
        sb.replace(position, position + 5, HORIZONTAL);
      }
    }

    return sb.toString();
  }
}
