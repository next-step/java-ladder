package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.domain.model.RandomGeneration;

public class Ladder {

  private List<LadderLine> ladderLines;

  public Ladder(int height, int width) {
    ladderLines = IntStream.range(0, height)
        .mapToObj(level -> LadderLine.init(width, RandomGeneration.getInstance()))
        .collect(Collectors.toList());
  }

  public int move(int position) {
    return ladderLines.stream()
        .reduce(position, (stopover, ladderLine) -> ladderLine.move(stopover), Integer::sum);
  }

  public void print() {
    ladderLines.forEach(LadderLine::print);
    System.out.println();
  }
}
