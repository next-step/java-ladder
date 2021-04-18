package nextstep.ladder.src;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Floor {
  private final List<Bridge> floor;

  public Floor(List<Bridge> floor) {
    this.floor = floor;
  }

  public static Floor makeByWidht(int width) {
    return new Floor(
      IntStream.range(0,  width)
      .boxed()
      .map(i -> new Bridge(new MakeBridgeByRandom()))
      .collect(Collectors.toList())
    );
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
