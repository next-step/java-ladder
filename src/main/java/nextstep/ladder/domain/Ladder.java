package nextstep.ladder.domain;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
  private final List<Line> lines;
  private final Height height;

  public Ladder(int countOfPerson, int maxHeight) {
    this(countOfPerson, new Height(maxHeight), new RandomLineConnectionStrategy());
  }

  public Ladder(int countOfPerson, Height height) {
    this(countOfPerson, height, new RandomLineConnectionStrategy());
  }

  public Ladder(int countOfPerson, Height height, LineConnectionStrategy strategy) {
    this(generateLines(countOfPerson, height, strategy), height);
  }

  public Ladder(List<Line> lines, Height height) {
    validateHeight(lines, height);
    this.lines = Collections.unmodifiableList(new ArrayList<>(lines));
    this.height = height;
  }

  private static List<Line> generateLines(int countOfPerson, Height height, LineConnectionStrategy strategy) {
    List<Line> lines = new ArrayList<>();
    for (int i = 0; i < height.getValue(); i++) {
      lines.add(new Line(countOfPerson, strategy));
    }
    return lines;
  }

  private static void validateHeight(List<Line> lines, Height height) {
    if (lines.size() > height.getValue()) {
      throw new IllegalArgumentException("최대 사다리 높이는 " + height.getValue() + "입니다.");
    }
  }

  public int findEnd(int position) {
    for (Line line : lines) {
      position = line.move(position);
    }
    return position;
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
