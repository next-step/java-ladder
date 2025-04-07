package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
  private final Players players;
  private final List<Line> lines;
  private final int height;

  public Ladder(Players players, int height) {
    this.players = players;
    this.height = height;
    this.lines = createLines(players.size(), height);
  }

  private List<Line> createLines(int countOfPerson, int height) {
    Random random = new Random();
    return IntStream.range(0, height)
        .mapToObj(i -> new Line(countOfPerson, position -> random.nextDouble() < 0.4))
        .collect(Collectors.toList());
  }

  public Line getLine(int index) {
    return lines.get(index);
  }

  public List<Line> getLines() {
    return new ArrayList<>(lines);
  }

  public int getHeight() {
    return height;
  }

  public Players getPlayers() {
    return players;
  }
}
