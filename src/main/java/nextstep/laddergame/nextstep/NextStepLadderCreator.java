package nextstep.laddergame.nextstep;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.laddergame.engine.LadderCreator;
import nextstep.laddergame.engine.Row;
import nextstep.laddergame.engine.strategy.LineStrategy;

public class NextStepLadderCreator implements LadderCreator {

  private final int height;
  private final int width;

  public NextStepLadderCreator(int height, int width) {
    if (height < 1) {
      throw new IllegalArgumentException("사다리의 높이는 1보다 작을 수 없습니다.");
    }

    if (width < 1) {
      throw new IllegalArgumentException("사다리의 넓이는 1보다 작을 수 없습니다.");
    }

    this.height = height;
    this.width = width;
  }

  public NextStepLadder createLadder(LineStrategy lineStrategy) {
    List<Row> rows = IntStream.range(0, height)
        .mapToObj(i -> Row.createRow(width, lineStrategy))
        .collect(Collectors.toList());

    return new NextStepLadder(rows);
  }
}
