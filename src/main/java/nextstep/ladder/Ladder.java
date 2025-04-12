package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
  private final List<Line> lines;

  public Ladder(int height, int countOfPlayers, DirectionStrategy strategy) {
    validate(height, countOfPlayers);
    this.lines = createLines(height, countOfPlayers, strategy);
  }

  private void validate(int height, int countOfPlayers) {
    if (height < 1) {
      throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
    }
    if (countOfPlayers < 2) {
      throw new IllegalArgumentException("참여자는 2명 이상이어야 합니다.");
    }
  }

  private List<Line> createLines(int height, int countOfPlayers, DirectionStrategy strategy) {
    List<Line> lines = new ArrayList<>();
    for (int i = 0; i < height; i++) {
      lines.add(new Line(countOfPlayers, strategy));
    }
    return lines;
  }

  public String toConsoleOutput() {
    return lines.stream()
            .map(Line::toConsoleOutput)
            .collect(Collectors.joining("\n"));
  }
}
