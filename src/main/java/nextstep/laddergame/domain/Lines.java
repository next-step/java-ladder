package nextstep.laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

  private final List<Line> entireLine;

  public Lines(List<Line> lines) {
    validateSize(lines.size());
    this.entireLine = lines;
  }

  public static Lines createLines(int height, int countOfMembers) {
    return new Lines(IntStream.range(0, height)
        .mapToObj(i -> Line.createLine(countOfMembers))
        .collect(Collectors.toList()));
  }

  private static void validateSize(int sizeOfLines) {
    if(sizeOfLines <= 0) {
      throw new IllegalArgumentException("ERROR : 0 혹은 0보다 낮은 수를 입력할 수 없습니다.");
    }
  }

  public List<Line> entireLine() {
    return this.entireLine;
  }
}
