package nextstep.ladder.domain;

import nextstep.ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Ladder {
  private static final int MIN_LADDER_HEIGHT = 1;
  private final List<Line> lines;
  private final List<String> results;

  public Ladder(int height, Players players, LineGenerateStrategy strategy, String results) {
    validate(height);
    this.lines = createLines(height, players, strategy);
    this.results = createResult(results, players);
  }

  private void validate(int height) {
    if (height < MIN_LADDER_HEIGHT) {
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

  private List<String> createResult(String results, Players players) {
    List<String> resultList = Stream.of(results.split(","))
            .map(String::trim)
            .collect(Collectors.toList());

    if (resultList.size() != players.size()) {
      throw new IllegalArgumentException("결과 수는 플레이어 수와 일치해야 합니다.");
    }

    return resultList;
  }

  public String toConsoleOutput() {
    return lines.stream()
            .map(Line::toConsoleOutput)
            .collect(Collectors.joining("\n"));
  }

  public String resultsOutput() {
    return results.stream()
            .map(result -> String.format("%" + OutputView.SPACE_WIDTH + "s", result))
            .collect(Collectors.joining());
  }

  public String resultAt(int index) {
    return results.get(index);
  }

  public int move(int index) {
    int position = index;
    for (Line line : lines) {
      position = line.move(position);
    }
    return position;
  }
}
