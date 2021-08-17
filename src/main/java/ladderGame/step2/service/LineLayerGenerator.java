package ladderGame.step2.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladderGame.step2.model.Line;

public class LineLayerGenerator {

  public static final int INT_ZERO = 0;

  public static List<Line> createLineLayer(int height, final int playerCount){
    return IntStream.range(INT_ZERO, height)
        .mapToObj(count -> new Line(playerCount))
        .collect(Collectors.toList());
  }
}