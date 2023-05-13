package ladder.domain;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import ladder.domain.strategy.NextPointGenerationStrategy;


public class LadderCreator {
  private final Height height;
  private final Participants participants;

  public LadderCreator(Height height, Participants participants) {
    this.height = height;
    this.participants = participants;
  }


  public Ladders createLadders(NextPointGenerationStrategy generationStrategy) {
    List<Line> listOfLines = createLines(generationStrategy);
    Lines lines = toLines(listOfLines);
    return new Ladders(lines);
  }

  private Lines toLines(List<Line> listOfLines) {
    return new Lines(listOfLines);
  }

  private List<Line> createLines(NextPointGenerationStrategy generationStrategy) {
    return Stream.generate(() -> Line.createLine(participants.size(), generationStrategy))
        .limit(getHeight())
        .collect(Collectors.toList());
  }

  private int getHeight() {
    return height.height();
  }

}
