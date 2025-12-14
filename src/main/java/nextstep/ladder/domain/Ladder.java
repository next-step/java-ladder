package nextstep.ladder.domain;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
  private final List<Line> lines;
  private final int maxHeight;

  public Ladder(int countOfPerson, int maxHeight) {
    this(generateLines(countOfPerson, maxHeight), maxHeight);
  }

  public Ladder(List<Line> lines, int maxHeight) {
    validateHeight(lines, maxHeight);
    this.lines = Collections.unmodifiableList(new ArrayList<>(lines));
    this.maxHeight = maxHeight;
  }

  private static List<Line> generateLines(int countOfPerson, int maxHeight) {
    List<Line> lines = new ArrayList<>();
    for (int i = 0; i < maxHeight; i++) {
      lines.add(new Line(countOfPerson));
    }
    return lines;
  }

  private static void validateHeight(List<Line> lines, int maxHeight) {
    if (lines.size() > maxHeight) {
      throw new IllegalArgumentException("최대 사다리 높이는 " + maxHeight + "입니다.");
    }
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    for(Line line : lines){
      sb.append(line).append("\n");
    }
    return sb.toString();
  }
}
