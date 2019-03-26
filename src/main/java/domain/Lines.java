package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
  private List<Line> lines;

  public Lines(int number, int height) {

    this.lines = IntStream.range(0, height)
        .mapToObj(index -> new Line(number))
        .collect(Collectors.toList());
  }

  public List<Line> gets() {
    return lines;
  }

  public int size() {
    return lines.size();
  }

  public int move(int participantPosition) {

    for(Line line : lines) {
      participantPosition = line.move(participantPosition);
    }

    return participantPosition;
  }
}
