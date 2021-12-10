package nextstep.ladder.domain.service;

import nextstep.ladder.domain.entity.Ladder;
import nextstep.ladder.domain.entity.LadderHeight;
import nextstep.ladder.domain.entity.Line;
import nextstep.ladder.domain.entity.Names;
import nextstep.ladder.domain.entity.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderService {

  private static final int INIT_INDEX = 0;
  private static final int FIRST_INDEX = 1;
  private static final int PREV = 1;
  private static final Boolean FALSE = false;

  private final Random random = new Random();

  public Ladder createLadder(LadderHeight height, Names names) {
    return IntStream.range(INIT_INDEX, height.howTall())
                    .mapToObj(index -> createLine(names.size()))
                    .collect(collectingAndThen(toList(), Ladder::new));
  }

  public Line createLine(int countOfPerson) {
    List<Point> points = initPoints();

    IntStream.range(FIRST_INDEX, countOfPerson)
             .forEach(now -> {
               int prevIndex = now - PREV;

               Point prevPoint = points.get(prevIndex);
               Point nowPoint = createPoint(prevPoint);

               points.add(nowPoint);
             });

    return new Line(points);
  }

  private List<Point> initPoints() {
    List<Point> points = new ArrayList<>();
    points.add(new Point(FALSE));
    return points;
  }

  public Point createPoint(Point prev) {
    if (prev.hasWay()) {
      return new Point(FALSE);
    }
    return new Point(random::nextBoolean);
  }

}
