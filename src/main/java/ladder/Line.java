package ladder;

public class Line {

  Positions positions;

  public Line(int playersCount) {
    positions = new Positions(playersCount);
  }

  public LineDisplay draw() {
    return positions.draw();
  }

}
