package nextstep.laddergame;

import java.util.ArrayList;
import java.util.List;
import nextstep.laddergame.domain.Line;

public class ProtoLine {
  private final List<Boolean> points;

  private ProtoLine(List<Boolean> points) {
    this.points = points;
  }

  public ProtoLine() {
    this(new ArrayList<>());
  }

  protected void add(Boolean next) {
    if (drewLeft()) {
      points.add(false);
      return;
    }

    points.add(next);
  }

  protected ProtoLine merge(ProtoLine other) {
    List<Boolean> result = new ArrayList<>(points);
    result.addAll(other.points);
    return new ProtoLine(result);
  }

  protected Line toLine() {
    return new Line(points);
  }

  private Boolean drewLeft() {
    return !points.isEmpty() && points.get(points.size() - 1);
  }

}
