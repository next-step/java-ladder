package nextstep.step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladders {

  private int ladderHeigh;

  public Ladders(int ladderHeigh) {
    this.ladderHeigh = ladderHeigh;
  }

  public int getLadderHeigh() {
    return ladderHeigh;
  }

  public List<Line> create(GameParticipants participants) {
    return Stream.generate(() -> new Line(participants)).limit(participants.getParticipantsSize())
        .collect(Collectors.toList());
  }
}
