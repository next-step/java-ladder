package nextstep.laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

  private final List<Line> lines;

  public Lines(List<Line> lines) {
    this.lines = lines;
  }

  public static Lines createLines(int height, int countOfMembers) {
    validation(height, countOfMembers);
    return new Lines(IntStream.range(0, height)
        .mapToObj(i -> Line.createLine(countOfMembers))
        .collect(Collectors.toList()));
  }

  private static void validation(int height, int countOfMembers) {
    validateHeight(height);
    validateCountOfMembers(countOfMembers);
  }

  private static void validateCountOfMembers(int countOfMembers) {
    if(countOfMembers <= 0) {
      throw new IllegalArgumentException("ERROR : 0 보다 낮은 수를 입력할 수 없습니다.");
    }
  }

  private static void validateHeight(int height) {
    if(height <= 0) {
      throw new IllegalArgumentException("ERROR : 0 보다 낮은 수를 입력할 수 없습니다.");
    }
  }

  public int dimension() {
    return lines.size() * lines.get(0).size();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    lines.stream()
        .map(Line::toString)
        .forEach(sb::append);

    return sb.toString();
  }
}
