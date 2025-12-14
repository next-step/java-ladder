package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
  private List<Boolean> points = new ArrayList<>();

  public Line(int countOfPerson){
    for (int i = 0; i < countOfPerson - 1; i++) {
      points.add(generatePoint(i));
    }
  }

  private boolean generatePoint(int position) {
    if (position == 0) {
      return Math.random() < 0.5;
    }
    if (points.get(position - 1)) {
      return false;
    }
    return Math.random() < 0.5;
  }

  public boolean hasConnectionAt(int position) {
    return points.get(position);
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("     ");
    for(int i = 0; i < points.size(); i++){
      sb.append("|").append(points.get(i)? "-----" : "     ");
    }
    sb.append("|");
    return sb.toString();
  }
}
