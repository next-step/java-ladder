package ladderGame.model;

import java.util.Collections;
import java.util.List;
import ladderGame.service.LineLayerGenerator;

public class Lines {

  private final List<Line> lines;

  public Lines(final int height, final int playersCount) {
    this.lines = Collections.unmodifiableList(LineLayerGenerator.createLineLayer(height, playersCount));
  }

  public List<Line> getLines() {
    return lines;
  }
}