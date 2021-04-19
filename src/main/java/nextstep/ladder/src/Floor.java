package nextstep.ladder.src;

import java.util.ArrayList;
import java.util.List;

public class Floor {
  private final List<Bridge> floor;

  public Floor(List<Bridge> floor) {
    this.floor = floor;
  }

  public static Floor makeByWidht(int width) {
    List<Bridge> list = new ArrayList<>();
    list.add(new Bridge(new MakeBridgeByRandom()));
    for(int i = 1; i < width; i++) {
      list.add(createBridge(list.get(i - 1)));
    }
    return new Floor(list);
  }

  private static Bridge createBridge(Bridge lastBridge) {
    if(lastBridge.isBridge()) {
      return new Bridge(false);
    }
    return new Bridge(new MakeBridgeByRandom());
  }

  public List<Bridge> floor() {
    return floor;
  }
}
