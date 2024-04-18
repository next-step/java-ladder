package nextstep.ladder.domain.dimension;

import nextstep.ladder.domain.generator.BooleanGenerator;

import static java.lang.Boolean.FALSE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line implements OneDimension{

  private final List<Point> points;

  public Line (int width, BooleanGenerator booleanGenerator) {
    this.points = makePoints(width, booleanGenerator);
  }

  public Line(List<Point> points) {
    this.points = points;
  }

  private static List<Point> makePoints(int width, BooleanGenerator booleanGenerator) {
    return IntStream.range(0, width)
        .mapToObj(i -> booleanGenerator.generate())
        .collect(ArrayList::new, (list, element) -> {
          if (list.isEmpty() || list.get(list.size() - 1).isNotBridge()) {
            list.add(Point.of(element));
            return ;
          }
          list.add(Point.of(FALSE));
        }, ArrayList::addAll);
  }

  public List<Point> getPoints() {
    return points;
  }

  @Override
  public int move(int index) {
    if(canMoveLeft(index)) {
      return index - 1;
    }

    if(canMoveRight(index)) {
      return index + 1;
    }
    return index;
  }

  private boolean canMoveLeft(int index){
    return index > 0 && !points.get(index-1).isNotBridge();
  }

  private boolean canMoveRight(int index){
    return index < points.size() && !points.get(index).isNotBridge();
  }

}
