package ladder;

public class Line {

  Points points;

  public Line(int playersCount) {
    points = new Points(playersCount);
  }

  public LineDisplay draw() {
    return points.draw();
  }

}
