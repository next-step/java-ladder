package ladder;

import java.util.List;
import java.util.stream.Collectors;

public class LadderDisplay {

  private List<LineDisplay> ladder;

  public LadderDisplay(List<LineDisplay> lines) {
    ladder = lines;
  }

  public List<String> draw() {
    return ladder.stream()
        .map(LineDisplay::draw)
        .collect(Collectors.toList());
  }
  
}
