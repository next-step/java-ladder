package nextstep.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladders {

  private int ladderHeigh;

  public Ladders(int ladderHeigh) {
    this.ladderHeigh = ladderHeigh;
  }

  public int getLadderHeigh() {
    return ladderHeigh;
  }

  public List<Line> create(GameParticipants gameParticipants) {
    List<Line> lines = new ArrayList<>();
    for (int i = 0; i < ladderHeigh; i++) {
      Line line = new Line();
      line.generator(gameParticipants);
      lines.add(line);
    }

    return lines;
  }
}
