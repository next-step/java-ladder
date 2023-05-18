package nextstep.laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.laddergame.domain.strategy.LineStrategy;
import nextstep.laddergame.factory.RowFactory;

public class LadderInfo {

  private final int height;
  private final int width;

  public LadderInfo(int height, int width) {
    if (height < 1) {
      throw new IllegalArgumentException("사다리의 높이는 1보다 작을 수 없습니다.");
    }

    if (width < 1) {
      throw new IllegalArgumentException("사다리의 넓이는 1보다 작을 수 없습니다.");
    }

    this.height = height;
    this.width = width;
  }

  public Ladder generateLadder(LineStrategy lineStrategy) {
    List<Row> rows = IntStream.range(0, height)
        .mapToObj(i -> RowFactory.createRow(width, lineStrategy))
        .collect(Collectors.toList());

    return new Ladder(rows);
  }
}
