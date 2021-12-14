package nextstep.ladder.domain.entity;

import java.util.List;
import java.util.stream.Stream;

public class Ladder {

  private static final String EMPTY_ERROR_MESSAGE = "사다리의 크기가 0이하일 수 없습니다.";
  private static final String NOT_SAME_SIZE_MESSAGE = "모든 줄이 같은 크기의 구성이 아닙니다.";
  private static final int FIRST_INDEX = 0;

  private final List<Line> lines;

  public Ladder(List<Line> lines) {
    validEmpty(lines);
    validLines(lines);
    this.lines = lines;
  }

  public Stream<Line> stream() {
    return lines.stream();
  }

  public int size() {
    return lines.size();
  }

  private void validEmpty(List<Line> lines) {
    if (lines.isEmpty()) {
      throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
    }
  }

  private void validLines(List<Line> lines) {
    Line firstLine = lines.get(FIRST_INDEX);

    if (!checkAllSameSize(lines, firstLine)) {
      throw new IllegalArgumentException(NOT_SAME_SIZE_MESSAGE);
    }
  }

  private boolean checkAllSameSize(List<Line> lines, Line firstLine) {
    return lines.stream()
                .allMatch(line -> line.size() == firstLine.size());
  }

  public int explore(int startingPoint) {
     int result = startingPoint;

     for (Line line : lines) {
       result = line.move(result);
     }

     return result;
  }
}
