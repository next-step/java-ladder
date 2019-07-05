package ladder;

import static java.util.stream.Collectors.joining;

import java.util.List;

public class LineDisplay {

  private static final String USER_LINE_SYMBOL = "|";
  private static final String JOINING_SYMBOL = "";

  String ladderLine;

  public LineDisplay(List<Point> points) {
    ladderLine = drawBody(points);
  }

  public String drawBody(List<Point> points) {
    return points.stream()
        .limit(points.size()-1)
        .map(Point::draw)
        .collect(joining(JOINING_SYMBOL));
  }

  public String draw() {
    ladderLine = drawEnds();
    return ladderLine;
  }

  private String drawEnds() {
    return ladderLine + USER_LINE_SYMBOL;
  }
}
