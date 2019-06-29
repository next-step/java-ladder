package ladder;

import static java.util.stream.Collectors.joining;

import java.util.List;

public class LineDisplay {

  private static final String USER_LINE_SYMBOL = "|";
  private static final String HORIZONTAL_LINE_SYMBOL = "-----";
  private static final String BLANK_SYMBOL = "     ";
  private static final String LINE_SEPARATOR = System.lineSeparator();

  String ladderLine;

  public LineDisplay(List<Boolean> positions) {
    ladderLine = drawBody(positions);
  }

  public String drawBody(List<Boolean> positions) {
    return positions.stream()
        .map(position -> position == true ? HORIZONTAL_LINE_SYMBOL : BLANK_SYMBOL)
        .collect(joining(USER_LINE_SYMBOL));
  }

  public String draw() {
    ladderLine = drawBothEnds();
    return ladderLine + LINE_SEPARATOR;
  }

  private String drawBothEnds() {
    return USER_LINE_SYMBOL + ladderLine + USER_LINE_SYMBOL;
  }
}
