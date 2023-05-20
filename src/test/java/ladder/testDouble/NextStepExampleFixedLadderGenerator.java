package ladder.testDouble;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.ladder.ladder.Ladder;
import ladder.domain.ladder.ladder.LadderGenerator;
import ladder.domain.ladder.line.HorizontalLadderLine;

/**
 * Step 3 예제에 나온대로 사다리를 생성해주는 double
 *
 * |-----|     |-----|
 * |     |-----|     |
 * |-----|     |     |
 * |     |-----|     |
 * |-----|     |-----|
 */
public class NextStepExampleFixedLadderGenerator implements LadderGenerator {

  @Override
  public Ladder generateLadderLines(int playerCnt, int ladderHeight) {
    int fixedPlayerCnt = 4;
    int fixedLadderHeight = 5;

    List<HorizontalLadderLine> lines = IntStream.range(0, fixedLadderHeight)
        .mapToObj(i -> new HorizontalLadderLine(fixedPlayerCnt))
        .collect(Collectors.toList());

    connectLikeSiteExample(lines);
    return new Ladder(lines);
  }

  private void connectLikeSiteExample(List<HorizontalLadderLine> lines) {
    HorizontalLadderLine line0 = lines.get(0);
    line0.connect(0, 1);
    line0.connect(2, 3);


    HorizontalLadderLine line1 = lines.get(1);
    line1.connect(1, 2);

    HorizontalLadderLine line2 = lines.get(2);
    line2.connect(0, 1);

    HorizontalLadderLine line3 = lines.get(3);
    line3.connect(1, 2);

    HorizontalLadderLine line4 = lines.get(4);
    line4.connect(0, 1);
    line4.connect(2, 3);
  }
}
