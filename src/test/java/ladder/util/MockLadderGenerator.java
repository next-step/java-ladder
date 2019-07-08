package ladder.util;

import ladder.model.Ladder;
import ladder.model.Layer;

import java.util.Arrays;

public class MockLadderGenerator {

  public static Ladder makeLadder() {
    Layer layer1 = new Layer(Arrays.asList(false, true, false));
    Layer layer2 = new Layer(Arrays.asList(false, false, true));
    Layer layer3 = new Layer(Arrays.asList(false, true, false));

    return new Ladder(Arrays.asList(layer1, layer2, layer3));
  }
}
