package nextstep.ladder.domain.service;

import nextstep.ladder.domain.entity.Ladder;
import nextstep.ladder.domain.entity.LadderHeight;
import nextstep.ladder.domain.entity.Line;
import nextstep.ladder.domain.entity.Names;

import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderService {

  private static final int ZERO = 0;
  private final Random random = new Random();

  public Ladder createLadder(LadderHeight height, Names names) {
    return IntStream.range(ZERO, height.howTall())
                    .mapToObj(index -> new Line(names.size(), random::nextBoolean))
                    .collect(collectingAndThen(toList(), Ladder::new));
  }

}
