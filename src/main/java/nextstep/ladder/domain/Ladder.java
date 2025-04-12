package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
  private final List<Line> lines;

  public Ladder(int height, Players players, LineGenerateStrategy strategy) {
    validate(height);
    this.lines = createLines(height, players, strategy);
  }

  private void validate(int height) {
    if (height < 1) {
      throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
    }
  }

  private List<Line> createLines(int height, Players players, LineGenerateStrategy strategy) {
    List<Line> lines = new ArrayList<>();
    for (int i = 0; i < height; i++) {
      lines.add(new Line(players, strategy));
    }
    return lines;
  }

  public String toConsoleOutput() {
    return lines.stream()
            .map(Line::toConsoleOutput)
            .collect(Collectors.joining("\n"));
  }
}
