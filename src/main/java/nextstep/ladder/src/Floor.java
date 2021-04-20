package nextstep.ladder.src;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Floor {
  private final List<Bridge> floor;

  public Floor(List<Bridge> floor) {
    checkBridgeOverlap(floor);
    this.floor = floor;
  }

  private void checkBridgeOverlap(List<Bridge> floor) {
    IntStream.range(1, floor.size())
      .forEach(i -> bothTrueException(floor.get(i - 1).isBridge(), floor.get(i).isBridge()));
  }

  private void bothTrueException(boolean lastIsBridge, boolean isBridge) {
    if(lastIsBridge && isBridge) {
      throw new IllegalArgumentException("bridge 는 연결되어 생성될 수 없습니다.");
    }
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
