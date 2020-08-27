package nextstep.ladder.biz;

public class LineAnalysis {

  private Line line;

  public LineAnalysis(Line line) {
    this.line = line;
  }

  public int stat(int index) {
    for (Point point : line.getLine()) {
      if (index == point.getPosition() && point.hasPoint()) {
        return index + 1;
      }

      if ((index-1) == point.getPosition() && point.hasPoint()) {
        return index - 1;
      }
    }
    return index;
  }
}
