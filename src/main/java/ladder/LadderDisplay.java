package ladder;

import java.util.List;
import java.util.stream.Collectors;

public class LadderDisplay {

  private static final String LINE_SEPARATOR = System.lineSeparator();
  private List<LineDisplay> ladder;

  public LadderDisplay(List<LineDisplay> lines) {
    ladder = lines;
  }

  public List<String> draw() {
    return ladder.stream()
        .map(LineDisplay::draw)
        .map(line -> appendLineSeparator(line))
        .collect(Collectors.toList());
  }

  private String appendLineSeparator(String line) {
    return line + LINE_SEPARATOR;
  }

}
