package ladder.domain;

import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.strategy.NextPointGenerationStrategy;


public class LadderGame {
  private final Height height;
  private final Participants participants;

  public LadderGame(Height height, Participants participants) {
    this.height = height;
    this.participants = participants;
  }


  public Ladders createLadders(NextPointGenerationStrategy generationStrategy) {
    List<Line> listOfLines = createLines(generationStrategy);
    Lines lines = toLines(listOfLines);
    return new Ladders(lines, height);
  }

  private Lines toLines(List<Line> listOfLines) {
    return new Lines(listOfLines);
  }

  private List<Line> createLines(NextPointGenerationStrategy generationStrategy) {
    return IntStream.range(0, getHeight())
        .mapToObj(createLine(generationStrategy))
        .collect(Collectors.toList());
  }

  private int getHeight() {
    return height.height();
  }

  private IntFunction<Line> createLine(NextPointGenerationStrategy generationStrategy) {
    return i -> new Line(participants.size(), generationStrategy);
  }

}
