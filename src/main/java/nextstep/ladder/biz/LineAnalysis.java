package nextstep.ladder.biz;

public class LineAnalysis {

  private Line line;

  public LineAnalysis(Line line) {
    this.line = line;
  }

  public void stat(Chessmen chessmen) {
    for (Point point : line.getLine()) {
      chessmen.down(point);
    }
  }

  public static void stat(Line line, Chessmen chessmen) {
    for (Point point : line.getLine()) {
      chessmen.down(point);
    }
  }
}
