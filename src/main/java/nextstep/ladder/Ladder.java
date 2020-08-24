package nextstep.ladder;

import java.util.Collections;
import java.util.List;

public class Ladder {

  private List<Horizon> horizons;

  public Ladder(List<Horizon> horizons) {
    this.horizons = horizons;
  }

  public List<Horizon> getHorizons() {
    return Collections.unmodifiableList(horizons);
  }
}
