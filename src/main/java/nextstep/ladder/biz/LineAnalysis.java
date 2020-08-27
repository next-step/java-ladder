package nextstep.ladder.biz;

public class LineAnalysis {

  private Line line;

  public LineAnalysis(Line line) {
    this.line = line;
  }

  public int stat(int index) {
    for (Point point : line.getLine()) {
      index = point.decide(index);
    }
    return index;
  }
}
