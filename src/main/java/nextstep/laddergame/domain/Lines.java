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

  public List<Line> entireLine() {
    return this.entireLine;
  }

  private static void validateSize(int sizeOfLines) {
    if(sizeOfLines <= 0) {
      throw new IllegalArgumentException("ERROR : 0 혹은 0보다 낮은 수를 입력할 수 없습니다.");
    }
  }

  public int next(int index) {
    int position = 0;
    while(!isLast(position)) {
      index = current(position).next(index);
      position++;
    }
    return index;
  }

  public int[] nextAll(Members members) {
    int[] results = new int[members.size()];
    for(int i = 0; i < members.size(); i++) {
      results[i] = next(i);
    }
    return results;
  }

  private Line current(int index) {
    return this.entireLine()
        .get(index);
  }

  public boolean isLast(int index) {
    return this.entireLine().size() == index;
  }
}
