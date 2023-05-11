package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LadderGame {
  private final Height height;
  private final Participants participants;

  public LadderGame(Height height, Participants participants) {
    this.height = height;
    this.participants = participants;
  }


  public Ladders createLadder(NextPointGenerationStrategy generationStrategy) {
    List<Line> lines = IntStream.range(0, height.height())
        .mapToObj(i-> new Line(participants.size(), generationStrategy))
        .collect(Collectors.toList());

    return new Ladders(new Lines(lines), height);
  }

}
