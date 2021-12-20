package nextstep.ladder.domain.service;

import nextstep.ladder.domain.entity.Ladder;
import nextstep.ladder.domain.entity.LadderHeight;
import nextstep.ladder.domain.entity.Line;
import nextstep.ladder.domain.entity.Name;
import nextstep.ladder.domain.entity.Names;
import nextstep.ladder.domain.entity.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderService {

  private static final int INIT_INDEX = 0;
  private static final int EXCLUSIVE_COUNT = 2;
  private static final int PREV = 1;

  private final Random random = new Random();

  public Ladder createLadder(LadderHeight height, Names names) {
    return IntStream.range(INIT_INDEX, height.howTall())
                    .mapToObj(index -> createLine(names.size()))
                    .collect(collectingAndThen(toList(), Ladder::new));
  }

  public Line createLine(int countOfPerson) {
    List<Point> points = new ArrayList<>();
    initFirst(points);

    initBody(points, countOfPerson);

    initLast(points);
    return new Line(points);
  }

  private void initFirst(List<Point> points) {
    points.add(Point.first(random.nextBoolean()));
  }

  private void initBody(List<Point> points, int countOfPerson) {
    IntStream.range(INIT_INDEX, countOfPerson - EXCLUSIVE_COUNT)
             .forEach(now -> {
               Point prevPoint = points.get(now);
               Point nowPoint = prevPoint.next(random.nextBoolean());

               points.add(nowPoint);
             });
  }

  private void initLast(List<Point> points) {
    Point prevPoint = points.get(points.size() - PREV);
    points.add(prevPoint.last());
  }

  public Map<String, Integer> gameStart(Ladder ladder, Names names) {
    Map<String, Integer> result = new HashMap<>();

    IntStream.range(INIT_INDEX, names.size())
             .forEach(index -> {
               Name name = names.getName(index);

               int endPoint = ladder.explore(index);

               result.put(name.tellName(), endPoint);
             });

    return result;
  }
}
