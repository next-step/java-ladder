package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.domain.model.RandomGeneration;

public class Ladder {

  private List<LadderLine> ladderLines;

  public Ladder(int height, int width) {
    ladderLines = IntStream.range(0, height)
        .mapToObj(level -> LadderLine.init(width, new RandomGeneration()))
        .collect(Collectors.toList());
  }

  public List<LadderLine> getLadderLines() {
    return Collections.unmodifiableList(ladderLines);
  }

  public int move(int position) {
    return 0;
  }
}
