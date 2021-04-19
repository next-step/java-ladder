package nextstep.ladder.src;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

  public String ui() {
    String str = floor.stream()
      .map(bridge -> BridgeUi.fromIsBridge(bridge).ui())
      .collect(Collectors.joining("|"));
    return "|" + str + "|";
  }
}
