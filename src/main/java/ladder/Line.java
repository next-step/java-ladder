package ladder;

public class Line {

  Points points;

  public Line(int playersCount) {
    points = new Points(playersCount);
  }

  public Line(Points points) {
    this.points = points;
  }

  public LineDisplay draw() {
    return points.draw();
  }

  public int move(int index) {
    return points.move(index);
  }

}
